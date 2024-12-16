package com.scaler.userservice.Services;

import com.scaler.userservice.Models.Token;
import com.scaler.userservice.Models.User;
import com.scaler.userservice.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

//    public UserServiceImpl(UserRepository userRepository,
//                                BCryptPasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
    @Override
    public Token login(String email, String password) {
        return null;
    }
    @Override
    public User signUp(String name, String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            //Redirect user to the login page.
            return optionalUser.get();
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setVerified(true);
        return userRepository.save(user);
    }
    @Override
    public void logout(String token) {
    }
    @Override
    public User validateToken(String token) {
        return null;
    }
}
