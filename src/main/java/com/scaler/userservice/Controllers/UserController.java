package com.scaler.userservice.Controllers;

import com.scaler.userservice.Dtos.LoginRequestDto;
import com.scaler.userservice.Dtos.LogoutRequestDto;
import com.scaler.userservice.Dtos.SignUpRequestDto;
import com.scaler.userservice.Dtos.UserDto;
import com.scaler.userservice.Models.Token;
import com.scaler.userservice.Models.User;
import com.scaler.userservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Token login(@RequestBody LoginRequestDto requestDto){
        return null;
    }
    @GetMapping("/logout")
    public ResponseEntity<Void> logout(LogoutRequestDto requestDto) {
        return null;
    }
    @GetMapping("/validate")
    public UserDto validateToken(String token) {
        return null;
    }
}
