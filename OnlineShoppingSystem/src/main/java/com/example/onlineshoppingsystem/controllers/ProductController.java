package com.example.onlineshoppingsystem.controllers;

import com.example.onlineshoppingsystem.dto.request.ProductDTORequest;
import com.example.onlineshoppingsystem.dto.response.SuccessResponse;
import com.example.onlineshoppingsystem.exception.InvalidInputDataException;
import com.example.onlineshoppingsystem.exception.NotFoundException;
import com.example.onlineshoppingsystem.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get-all-product")
    public ResponseEntity getAllProduct(@RequestParam int pageIndex, @RequestParam int pageSize) {
        return new ResponseEntity(new SuccessResponse(productService.getAllProduct(pageIndex, pageSize)), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity getProductById(@PathVariable long productId) {
        return new ResponseEntity(new SuccessResponse((productService.getProductById(productId))), HttpStatus.OK);
    }

    @PostMapping("/add-product")
    public ResponseEntity addProduct(@RequestBody ProductDTORequest dto) throws InvalidInputDataException {
        productService.addProduct(dto);
        return new ResponseEntity(new SuccessResponse("Add product successfully!"), HttpStatus.OK);
    }

    @PutMapping("/edit-product-info/{productId}")
    public ResponseEntity editProductBasicInfo(@PathVariable Long productId, @RequestBody ProductDTORequest dto) throws Exception {
        productService.editProductBasicInfo(productId, dto);
        return new ResponseEntity(new SuccessResponse("Edit product info successfully!"), HttpStatus.OK);
    }

    @PutMapping("/edit-product-files/{productId}")
    public ResponseEntity editProductFiles(@PathVariable Long productId, @RequestBody List<MultipartFile> uploadFiles) throws Exception {
        productService.editProductFiles(productId, uploadFiles);
        return new ResponseEntity(new SuccessResponse("Edit product files successfully!"), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestParam long productId) throws NotFoundException {
        productService.deleteById(productId);
        return new ResponseEntity(new SuccessResponse("Delete product successfully!"), HttpStatus.OK);
    }
}
