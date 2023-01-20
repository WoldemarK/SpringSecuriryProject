package com.example.SpringSecuriryProject.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private String username;
    private String password;
    private int birth;
}
