package com.example.SpringSecuriryProject.util;

import com.example.SpringSecuriryProject.model.User;
import com.example.SpringSecuriryProject.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean supports(Class<?> aClazz) {
        return User.class.equals(aClazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        try {
            userDetailsService.loadUserByUsername(user.getUsername());
        } catch (UsernameNotFoundException ignored) {
            return;
        }
        errors.rejectValue("username","", "Человек с таким именем уже существует");
    }
}
