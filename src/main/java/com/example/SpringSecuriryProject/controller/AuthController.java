package com.example.SpringSecuriryProject.controller;

import com.example.SpringSecuriryProject.dto.UserDto;
import com.example.SpringSecuriryProject.model.User;
import com.example.SpringSecuriryProject.security.JWTUtil;
import com.example.SpringSecuriryProject.service.RegistrationService;
import com.example.SpringSecuriryProject.util.UserValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserValidator userValidator;
    private final RegistrationService registrationService;
    private final JWTUtil jwtUtil;
    private final ModelMapper modelMapper;

    @GetMapping("/login")
    public String loginPage() {
        return "/auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "/auth/registration";
    }

    @PostMapping("/registration")
    public Map<String, String> performRegistration(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        User user = convertToUser(userDto);
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors())
            return Map.of("message", "Ошибка");

        registrationService.register(user);

        String token = jwtUtil.generateToken(user.getUsername());
        return Map.of("jwt-token", token);
    }

    public User convertToUser(UserDto userDto) {
        return this.modelMapper.map(userDto, User.class);
    }
}
