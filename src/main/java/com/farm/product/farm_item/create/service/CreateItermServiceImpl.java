package com.farm.product.farm_item.create.service;

import com.farm.product.shared.utility.GlobalException.ProductAlreadyExistsException;
import com.farm.product.shared.utility.Repository.RegisterItemRepo;
import com.farm.product.shared.utility.RequestDto.RegisterItemRequest;
import com.farm.product.shared.utility.Utility;
import com.farm.product.shared.utility.entity.RegisterItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateItermServiceImpl implements CreateItemService {
    @Autowired
    private RegisterItemRepo registerItemRepo;
    @Autowired
    private Utility utility;
    @Override
    public RegisterItem createProduct(RegisterItemRequest dto) {
        if (registerItemRepo.existsByProductIdAndSellerId(dto.getProductId(), dto.getSellerId())) {
            throw new ProductAlreadyExistsException(
                    "Product '" + dto.getProductId() + "' already exists for seller ID: " + dto.getSellerId()
            );
        }

        RegisterItem product = RegisterItem.builder()
                .sellerId(dto.getSellerId())
                .productName(utility.getDescriptionById(dto.getProductId()))
                .estimatedQuantity(dto.getEstimatedQuantity())
                .availabilityOn(dto.getAvailabilityOn())
                .productId(dto.getProductId())
                .build();

        return registerItemRepo.save(product);
    }
}
