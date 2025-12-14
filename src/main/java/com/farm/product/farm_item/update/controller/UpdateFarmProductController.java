package com.farm.product.farm_item.update.controller;

import com.farm.product.farm_item.update.dto.RequestDto.UpdateFarmerProductRequest;
import com.farm.product.farm_item.update.service.UpdateFarmProductService;
import com.farm.product.shared.utility.APIResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/farm-product")
@CrossOrigin(origins = "*")
public class UpdateFarmProductController {

    private final UpdateFarmProductService updateFarmService;

    public UpdateFarmProductController(UpdateFarmProductService updateFarmService) {
        this.updateFarmService = updateFarmService;
    }

    /**
     * Updates a farmer's product details (quantity, status, timestamp, etc.)
     */
    @PutMapping("/update")
    public ResponseEntity<APIResponse> updateFarmerProduct(@Valid @RequestBody UpdateFarmerProductRequest request) {
        APIResponse response = new APIResponse();

        boolean updated = updateFarmService.updateProduct(request);

        if (updated) {
            response.setStatus("SUCCESS");
            response.setMessage("Product updated successfully");
            response.setData(request);
            return ResponseEntity.ok(response);
        } else {
            response.setStatus("FAILED");
            response.setMessage("Product update failed. Please check if product exists or data is valid.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
