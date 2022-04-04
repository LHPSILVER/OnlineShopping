package com.example.onlineshoppingsystem.services.impl;

import com.example.onlineshoppingsystem.dto.request.UserRequestDTO;
import com.example.onlineshoppingsystem.services.AuthService;
import com.example.onlineshoppingsystem.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserService userService;

    public AuthServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Integer signUp(UserRequestDTO userRequestDTO) {
        userService.saveNewUser(userRequestDTO);
        return 1;
    }
}
