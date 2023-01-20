package com.example.SpringSecuriryProject.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @PreAuthorize("hesRole('ROLE_ADMIN')and hesRole('ROLE_SOME_OTHER')")
    public void doAdminStuff(){
        System.out.println("Only admin here");
    }
}
