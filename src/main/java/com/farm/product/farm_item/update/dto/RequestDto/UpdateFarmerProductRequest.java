package com.farm.product.farm_item.update.dto.RequestDto;

import com.farm.product.shared.utility.CodeGroup;
import com.farm.product.shared.utility.FarmingStatusCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UpdateFarmerProductRequest {
    @NotNull(message = "Seller ID is required")
    @Min(value = 1, message = "Seller ID must be positive")
    @JsonProperty("seller_id")
    private Long sellerId;

    @NotNull(message = "Product ID is required")
    //@Min(value = 1, message = "Product ID must be positive")
    @JsonProperty("product_id")
    private CodeGroup product;

    @Min(value = 0, message = "Quantity must be non-negative")
    @JsonProperty("est_quant")
    private Integer estimatedQuantity;

    @Min(value = 0, message = "Quantity must be non-negative")
    @JsonProperty("achived_quant")
    private Integer achivedQuantity;

    @NotNull(message = "Updated date is required")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updated_time_stamp")
    private LocalDateTime updatedTimeStamp;

    @JsonProperty("avability_on")
    private LocalDate availabilityOn;
    /**
     * Represents the current product lifecycle status (e.g., FRUIT_RIPENING, HARVESTED, SOLD_TO_COMPANY)
     */
    @NotNull(message = "Product status is required")
    @JsonProperty("product_status")
    private FarmingStatusCode productStatus;
}