package com.example.SpringSecuriryProject.controller;

import com.example.SpringSecuriryProject.security.UserDetailsImpl;
import com.example.SpringSecuriryProject.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final AdminService adminService;

    @GetMapping("/test")
    public String getTest() {
        return "/test";
    }
    @GetMapping("/showUserInfo")
    public String showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        System.out.println(userDetails.getUser());
        return "/test";
    }
    @GetMapping("/admin")
    public String adminPage(){
        adminService.doAdminStuff();
      return "/admin";
    }
}
