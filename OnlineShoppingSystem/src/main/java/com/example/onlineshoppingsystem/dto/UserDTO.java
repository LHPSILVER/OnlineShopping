package com.example.onlineshoppingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean gender = false;
    private String identityCard;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;
}
