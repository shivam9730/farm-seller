package com.farm.product.farm_item.update.service;

import com.farm.product.farm_item.update.dto.RequestDto.UpdateFarmerProductRequest;

public interface UpdateFarmProductService {
    boolean updateProduct(UpdateFarmerProductRequest product);
}