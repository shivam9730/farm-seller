package com.farm.product.farm_item.create.controller;

import com.farm.product.farm_item.create.service.CreateItermServiceImpl;
import com.farm.product.shared.utility.APIResponse;
import com.farm.product.shared.utility.RequestDto.RegisterItemRequest;
import com.farm.product.shared.utility.entity.RegisterItem;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class CreateItemController {
    @Autowired
    private CreateItermServiceImpl service;

    // Create new product
    @PostMapping("/seller/create")
    public ResponseEntity<APIResponse> createProduct(@Valid @RequestBody RegisterItemRequest dto) {
        RegisterItem product = service.createProduct(dto);
        APIResponse response = new APIResponse("SUCCESS", product);
        response.setMessage("Product created successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
