package com.example.onlineshoppingsystem.dto.response;

import com.example.onlineshoppingsystem.dto.CategoryDTO;
import com.example.onlineshoppingsystem.dto.FileDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ProductDTOResponse {
    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;
    private Double ratingScore;
    private String manufacturedFactory;
    private String madeIn;
    private List<CategoryDTO> categories;
    private List<FileDTO> files;
}
