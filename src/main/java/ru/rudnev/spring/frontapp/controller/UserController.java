package ru.rudnev.spring.frontapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rudnev.spring.frontapp.model.User;
import ru.rudnev.spring.frontapp.service.UserService;

@Controller
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

    @GetMapping("/users/new")
    public String addUser(Model model) {
        model.addAttribute("user", userService.addUser());
        model.addAttribute("pageTitle", "Create new User");

        return "user_form";
    }

    @PostMapping("users/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes) {
        try {
            userService.saveUser(user);

            redirectAttributes.addFlashAttribute("message", "The User has been saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addAttribute("message", e.getMessage());
        }

        return "redirect:/users";
    }

    @GetMapping("users/{id}")
    public String editUser(@PathVariable("id") int id,Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("user", userService.editUser(id));
            model.addAttribute("pageTitle", "Edit User (ID: " + id + ")");

            return "user_form";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

            return "redirect:/users";
        }
    }

    @GetMapping("users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            userService.deleteUser(id);

            redirectAttributes.addFlashAttribute("message", "The Tutorial with id=" + id + " has been deleted successfully!");
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());


        }
        return "redirect:/users";
    }
}
