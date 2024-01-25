package ru.rudnev.spring.frontapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rudnev.spring.frontapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
