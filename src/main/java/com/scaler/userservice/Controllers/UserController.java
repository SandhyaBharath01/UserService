package com.scaler.userservice.Controllers;

import com.scaler.userservice.Dtos.*;
import com.scaler.userservice.Exceptions.ValidTokenNotFoundException;
import com.scaler.userservice.Models.Token;
import com.scaler.userservice.Models.User;
import com.scaler.userservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping("/signup")
    public UserDto signUp(@RequestBody SignUpRequestDto requestDto){
        User user = userService.signUp(requestDto.getName(),
                                        requestDto.getEmail(),
                                        requestDto.getPassword());
        return UserDto.from(user);

    }
    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginRequestDto requestDto){
        Token token = userService.login(
                requestDto.getEmail(),
                requestDto.getPassword()
        );
        //Convert token to TokenDto
        return TokenDto.from(token);
    }
    @GetMapping("/logout")
    public ResponseEntity<Void> logout(LogoutRequestDto requestDto) {
        ResponseEntity<Void> responseEntity = null;
        userService.logout(requestDto.getTokenValue());
        responseEntity = new ResponseEntity<>(
                HttpStatus.OK
        );
        //TODO : Move the exception handling logic inside the Controller Advice.
        return responseEntity;
    }
    @GetMapping("/validate")
    public UserDto validateToken(String token) {
        return null;
    }
}
