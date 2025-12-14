package com.farm.product.farm_item.create.service;

import com.farm.product.shared.utility.GlobalException.ProductAlreadyExistsException;
import com.farm.product.shared.utility.Repository.RegisterItemRepo;
import com.farm.product.farm_item.create.dto.RequestDto.RegisterItemRequest;
import com.farm.product.shared.utility.Utility;
import com.farm.product.shared.utility.entity.FarmerProduct;
import org.springframework.stereotype.Service;

@Service
public class CreateItemServiceImpl implements CreateItemService {
    private final RegisterItemRepo registerItemRepo;
    private final Utility utility;

    public CreateItemServiceImpl(RegisterItemRepo registerItemRepo, Utility utility) {
        this.registerItemRepo = registerItemRepo;
        this.utility = utility;
    }

    @Override
    public FarmerProduct createProduct(RegisterItemRequest dto) {
        if (registerItemRepo.existsByProductIdAndSellerId(dto.getProduct().getCodeId(), dto.getSellerId())) {
            throw new ProductAlreadyExistsException(
                    "Product '" + dto.getProduct().getCodeId() + "' already exists for seller ID: " + dto.getSellerId()
            );
        }

        FarmerProduct product = FarmerProduct.builder()
                .sellerId(dto.getSellerId())
                .productName(utility.getDescriptionById(dto.getProduct().getCodeId()))
                .estimatedQuantity(dto.getEstimatedQuantity())
                .availabilityOn(dto.getAvailabilityOn())
                .productId(dto.getProduct().getCodeId())
                .build();

        return registerItemRepo.save(product);
    }
}
