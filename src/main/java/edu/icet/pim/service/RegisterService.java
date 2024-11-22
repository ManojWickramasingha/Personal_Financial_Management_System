package edu.icet.pim.service;

import edu.icet.pim.model.User;
import edu.icet.pim.model.UserLogin;
import edu.icet.pim.reponse.LoginMessage;

public interface RegisterService {
    Boolean registerUser(User user);

    LoginMessage userLogin(UserLogin userLogin);
}
