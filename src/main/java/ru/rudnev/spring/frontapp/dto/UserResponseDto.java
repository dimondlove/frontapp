package ru.rudnev.spring.frontapp.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private int id;

    private String username;

    private String email;
}
