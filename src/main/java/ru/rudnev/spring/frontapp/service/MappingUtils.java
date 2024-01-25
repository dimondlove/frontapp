package ru.rudnev.spring.frontapp.service;

import org.springframework.stereotype.Service;
import ru.rudnev.spring.frontapp.dto.UserCreateDto;
import ru.rudnev.spring.frontapp.dto.UserResponseDto;
import ru.rudnev.spring.frontapp.model.User;

@Service
public class MappingUtils {
    public UserResponseDto mapToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setEmail(user.getEmail());

        return userResponseDto;
    }

    public User mapToUser(UserCreateDto userCreateDto) {
        User user = new User();
        setDataUser(user, userCreateDto);

        return user;
    }

    public void setDataUser(User user, UserCreateDto userCreateDto) {
        user.setUsername(userCreateDto.getUsername());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(userCreateDto.getPassword());
    }
}