package edu.icet.pim.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.pim.entity.UserEntity;
import edu.icet.pim.model.User;
import edu.icet.pim.model.UserLogin;
import edu.icet.pim.reponse.LoginMessage;
import edu.icet.pim.repository.RegisterRepository;
import edu.icet.pim.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepository repository;
    private final ObjectMapper mapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public String registerUser(User user) {
        UserEntity userEntity = mapper.convertValue(user, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity save = repository.save(userEntity);
        return save.getName();
    }

    @Override
    public LoginMessage userLogin(UserLogin userLogin) {

        UserEntity byEmail = repository.findByEmail(userLogin.getEmail());
        if(byEmail != null){
            boolean isMatches = passwordEncoder.matches(userLogin.getPassword(), byEmail.getPassword());
            if(isMatches){
                Optional<UserEntity> users = repository.findOneByEmailAndPassword(userLogin.getEmail(), byEmail.getPassword());
                if(users.isPresent()){
                    return new LoginMessage("Login Success", true);
                }else{
                    return new LoginMessage("Login Failed", false);
                }
            }else{
                return new LoginMessage("password Not Match", false);
            }
        }else{
            return new LoginMessage("Email not exits", false);
        }

        
    }
}
