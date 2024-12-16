package com.scaler.userservice.Dtos;

import com.scaler.userservice.Models.Role;
import com.scaler.userservice.Models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;

    private List<Role> roles;

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public static UserDto from(User user) {
        if (user == null) return null;
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

}
