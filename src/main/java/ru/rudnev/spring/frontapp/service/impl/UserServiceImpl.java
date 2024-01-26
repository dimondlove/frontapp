package ru.rudnev.spring.frontapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rudnev.spring.frontapp.dto.UserResponseDto;
import ru.rudnev.spring.frontapp.model.User;
import ru.rudnev.spring.frontapp.repository.UserRepository;
import ru.rudnev.spring.frontapp.service.MappingUtils;
import ru.rudnev.spring.frontapp.service.UserService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MappingUtils mappingUtils;

    @Override
    public Collection<UserResponseDto> getAllUsers() {
        Collection<User> users = userRepository.findAll();
        return users
                .stream()
                .map(mappingUtils::mapToUserResponseDto)
                .toList();
    }

    @Override
    public User addUser() {
        return new User();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User editUser(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
