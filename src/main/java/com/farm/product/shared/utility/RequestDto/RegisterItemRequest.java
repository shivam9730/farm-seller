package com.farm.product.shared.utility.RequestDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterItemRequest {
    @NotNull(message = "Seller ID is required")
    @Min(value = 1, message = "Seller ID must be positive")
    @JsonProperty("seller_id")
    private Long sellerId;

    @NotNull(message = "Seller ID is required")
    @Min(value = 1, message = "Product ID must be positive")
    @JsonProperty("product_id")
    private Long productId;

    // Product ID is auto-generated, so not included in DTO for creation

   /* @NotBlank(message = "Product name is required")
    @Size(max = 255, message = "Product name must not exceed 255 characters")
    @JsonProperty("product_name")
    private String productName;*/

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity must be non-negative")
    @JsonProperty("est_quant")
    private Integer estimatedQuantity;

    @Min(value = 0, message = "Quantity must be non-negative")
    @JsonProperty("achived_quant")
    private Integer achivedQuantity;

    @NotNull(message = "Availability date is required")
    @JsonProperty("avability_on")
    private LocalDate availabilityOn;

}

