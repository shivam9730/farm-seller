package com.farm.product.farm_item.create.service;

import com.farm.product.shared.utility.RequestDto.RegisterItemRequest;
import com.farm.product.shared.utility.entity.RegisterItem;
import org.springframework.stereotype.Service;

@Service
public interface CreateItemService {
    RegisterItem createProduct(RegisterItemRequest dto);
}
