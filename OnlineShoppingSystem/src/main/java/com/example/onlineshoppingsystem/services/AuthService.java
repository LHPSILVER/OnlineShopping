package com.example.onlineshoppingsystem.services;

import com.example.onlineshoppingsystem.dto.request.UserRequestDTO;

public interface AuthService {
    Integer signUp(UserRequestDTO userRequestDTO);
}
