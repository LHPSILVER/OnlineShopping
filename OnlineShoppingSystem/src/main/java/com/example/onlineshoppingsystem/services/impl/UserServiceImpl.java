package com.example.onlineshoppingsystem.services.impl;

import com.example.onlineshoppingsystem.dto.request.UserRequestDTO;
import com.example.onlineshoppingsystem.entities.user.EnumRole;
import com.example.onlineshoppingsystem.entities.user.Role;
import com.example.onlineshoppingsystem.entities.user.User;
import com.example.onlineshoppingsystem.repositories.RoleRepository;
import com.example.onlineshoppingsystem.repositories.UserRepository;
import com.example.onlineshoppingsystem.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository,
                           UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void saveNewUser(UserRequestDTO userRequestDTO) {
        //id auto-generated
        userRequestDTO.setUserId(null);
        User user = modelMapper.map(userRequestDTO, User.class);

        Role role_user = new Role(1L, EnumRole.ROLE_USER, null);
        user.setRole(new ArrayList<>());
        user.getRole().add(role_user);
        user.setVerified(false);
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        userRepository.save(user);
    }
}
