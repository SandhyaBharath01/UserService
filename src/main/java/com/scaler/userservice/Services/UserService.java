package com.scaler.userservice.Services;

import com.scaler.userservice.Exceptions.ValidTokenNotFoundException;
import com.scaler.userservice.Models.Token;
import com.scaler.userservice.Models.User;
import com.scaler.userservice.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {
    Token login(String email, String password);
    User signUp(String name, String email, String password);
    void logout(String token);
    User validateToken(String token) throws ValidTokenNotFoundException;
}
