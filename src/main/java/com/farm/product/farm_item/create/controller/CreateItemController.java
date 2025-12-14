package com.farm.product.farm_item.create.controller;

import com.farm.product.farm_item.create.service.CreateItemService;
import com.farm.product.shared.utility.APIResponse;
import com.farm.product.farm_item.create.dto.RequestDto.RegisterItemRequest;
import com.farm.product.shared.utility.entity.FarmerProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class CreateItemController {
    private final CreateItemService service;

    public CreateItemController(CreateItemService service) {
        this.service = service;
    }

    @Operation(
            description = "Using this endpoint to create product by any seller",
            summary = "Create Product Endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    ),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "404"
                    )
            }

    )
    @PostMapping("/seller/create")
    public ResponseEntity<APIResponse> createProduct(@Valid @RequestBody RegisterItemRequest dto) {
        FarmerProduct product = service.createProduct(dto);
        APIResponse response = new APIResponse("SUCCESS", product);
        response.setMessage("Product created successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
