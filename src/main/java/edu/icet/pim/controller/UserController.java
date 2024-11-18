package edu.icet.pim.controller;

import edu.icet.pim.model.User;
import edu.icet.pim.model.UserLogin;
import edu.icet.pim.reponse.LoginMessage;
import edu.icet.pim.service.RegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final RegisterService service;
    @PostMapping("/registration")
    public String registerUser(@Valid @RequestBody User user){
        return service.registerUser(user);
    }

    @PostMapping("/login")
    public LoginMessage loginUser(@RequestBody UserLogin userLogin){
        return service.userLogin(userLogin);
    }
}
