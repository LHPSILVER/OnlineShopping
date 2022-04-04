package com.example.onlineshoppingsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResponse {
    private Boolean result = true;
    private Object response;

    public SuccessResponse(Object response) {
        this.response = response;
    }
}
