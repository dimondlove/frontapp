package ru.rudnev.spring.frontapp.service;

import ru.rudnev.spring.frontapp.dto.UserResponseDto;
import ru.rudnev.spring.frontapp.model.User;

import java.util.Collection;

public interface UserService {
    Collection<UserResponseDto> getAllUsers();

    User addUser();

    void saveUser(User user);

    User editUser(int id);

    void deleteUser(int id);
}
