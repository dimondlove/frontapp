package ru.rudnev.spring.frontapp.dto;

import lombok.Data;

@Data
public class UserCreateDto {

    private String username;

    private String email;

    private String password;
}