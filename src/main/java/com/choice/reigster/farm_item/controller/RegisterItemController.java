package com.choice.reigster.farm_item.controller;

import com.choice.reigster.farm_item.service.RegisterItermServiceImpl;
import com.choice.reigster.shared.utility.APIResponse;
import com.choice.reigster.shared.utility.RequestDto.RegisterItemRequest;
import com.choice.reigster.shared.utility.entity.RegisterItem;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class RegisterItemController {
    @Autowired
    private RegisterItermServiceImpl service;

    // Create new product
    @PostMapping("/seller/create")
    public ResponseEntity<APIResponse> createProduct(@Valid @RequestBody RegisterItemRequest dto) {
        RegisterItem product = service.createProduct(dto);
        APIResponse response = new APIResponse("SUCCESS", product);
        response.setMessage("Product created successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
