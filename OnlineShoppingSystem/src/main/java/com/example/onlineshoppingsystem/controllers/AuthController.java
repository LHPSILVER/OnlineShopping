package com.example.onlineshoppingsystem.controllers;

import com.example.onlineshoppingsystem.dto.request.UserRequestDTO;
import com.example.onlineshoppingsystem.dto.response.SuccessResponse;
import com.example.onlineshoppingsystem.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody UserRequestDTO userRequestDTO) {
        authService.signUp(userRequestDTO);
        return ResponseEntity.ok(new SuccessResponse("Register successfully!"));
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Chuong, you get there with a cool jwt";
    }
}