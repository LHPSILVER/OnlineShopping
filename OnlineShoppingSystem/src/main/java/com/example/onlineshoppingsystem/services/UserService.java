package com.example.onlineshoppingsystem.services;

import com.example.onlineshoppingsystem.dto.request.UserRequestDTO;

public interface UserService {
    void saveNewUser(UserRequestDTO userRequestDTO);
}
