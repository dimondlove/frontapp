package ru.rudnev.spring.frontapp.service;

import ru.rudnev.spring.frontapp.dto.UserResponseDto;

import java.util.Collection;

public interface UserService {
    Collection<UserResponseDto> getAllUsers();
}
