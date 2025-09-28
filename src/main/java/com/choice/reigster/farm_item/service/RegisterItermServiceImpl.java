package com.choice.reigster.farm_item.service;

import com.choice.reigster.shared.utility.GlobalException.ProductAlreadyExistsException;
import com.choice.reigster.shared.utility.Repository.RegisterItemRepo;
import com.choice.reigster.shared.utility.RequestDto.RegisterItemRequest;
import com.choice.reigster.shared.utility.Utility;
import com.choice.reigster.shared.utility.entity.RegisterItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterItermServiceImpl implements RegisterItemService{
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
