package com.example.autobase.controllers;

import com.example.autobase.controllers.response.Response;
import com.example.autobase.models.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Login")
@CrossOrigin(origins = {"http://localhost:3000"})
public class LoginController {
    @GetMapping("/")
    public ResponseEntity<Object> login() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok().body(new Response<>(auth, HttpStatus.OK.value(), "User found"));
    }
}
