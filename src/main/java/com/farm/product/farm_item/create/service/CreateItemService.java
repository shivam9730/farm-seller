package com.farm.product.farm_item.create.service;

import com.farm.product.farm_item.create.dto.RequestDto.RegisterItemRequest;
import com.farm.product.shared.utility.entity.FarmerProduct;
import org.springframework.stereotype.Service;

@Service
public interface CreateItemService {
    FarmerProduct createProduct(RegisterItemRequest dto);
}
