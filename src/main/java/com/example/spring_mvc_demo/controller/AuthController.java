package com.example.spring_mvc_demo.controller;

import com.example.spring_mvc_demo.dto.RegistrationDto;
import com.example.spring_mvc_demo.models.UserEntity;
import com.example.spring_mvc_demo.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@NoArgsConstructor
@Controller
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model){
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String postRegisterForm(@Valid @ModelAttribute("user") RegistrationDto user, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }
        UserEntity existingUser = userService.findByEmail(user.getEmail());
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", "This email is already in use");
            return "register";
        }
        UserEntity existingUsername = userService.findByUsername(user.getUsername());
        if (existingUsername != null && existingUsername.getUsername() != null && !existingUsername.getUsername().isEmpty()){
            result.rejectValue("username", "This username is already in use");
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/clubs?success";
    }
}
