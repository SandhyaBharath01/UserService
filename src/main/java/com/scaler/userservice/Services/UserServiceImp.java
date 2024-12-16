package com.scaler.userservice.Services;

import com.scaler.userservice.Models.Token;
import com.scaler.userservice.Models.User;
import com.scaler.userservice.Repositories.TokenRepository;
import com.scaler.userservice.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private TokenRepository tokenRepository;

//    public UserServiceImpl(UserRepository userRepository,
//                                BCryptPasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
    @Override
    public Token login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            return null;
        }
        User user = optionalUser.get();
        Token token = null;
        if (passwordEncoder.matches(password, user.getPassword())) {
            //Login successful.
            token = new Token();
            token.setUser(user);
            // Expiry time should be 30 days from now.
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, 30);
            Date date30DaysFromNow = calendar.getTime();
            token.setExpiryAt(date30DaysFromNow);
//            token.setExpiryAt(new Date());
            //Token value can be any random String of 128 characters.
            token.setValue(RandomStringUtils.randomAlphanumeric(128));
        }
        return tokenRepository.save(token);
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
