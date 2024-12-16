package com.scaler.userservice.Dtos;

import com.scaler.userservice.Models.Token;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogoutRequestDto {
    private Token token;
}
