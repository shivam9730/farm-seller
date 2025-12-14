package com.farm.product.shared.utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FarmingStatusDetails {
    private String productType;     // "NON_VEG"
    private String subCategory;     // "LIVESTOCK"
    private String phase;           // "Breeding"
    private String status;          // "ANIMAL_PURCHASED"
    private String statusDetails;   // "Animal purchased for rearing."
}