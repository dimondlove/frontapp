package ru.rudnev.spring.frontapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rudnev.spring.frontapp.service.UserService;

@Controller
@RequestMapping(path="/app")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        try {
            model.addAttribute("users", userService.getAllUsers());
        }
        catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "users";
    }
}
