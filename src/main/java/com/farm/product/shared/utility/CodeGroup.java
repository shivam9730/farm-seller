package com.farm.product.shared.utility;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CodeGroup {
    @NotNull(message = "Code ID is required")
    @Min(value = 1, message = "Code ID must be positive")
    private Long codeId;
    private String codeName;
}