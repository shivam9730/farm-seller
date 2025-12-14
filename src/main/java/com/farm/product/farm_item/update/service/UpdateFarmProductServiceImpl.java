package com.farm.product.farm_item.update.service;

import com.farm.product.shared.utility.FarmingStatusCode;
import com.farm.product.farm_item.update.dto.RequestDto.UpdateFarmerProductRequest;
import com.farm.product.shared.utility.GlobalException.ProductNotFoundException;
import com.farm.product.shared.utility.Repository.RegisterItemRepo;
import com.farm.product.shared.utility.entity.FarmerProduct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class UpdateFarmProductServiceImpl implements UpdateFarmProductService {

    private final RegisterItemRepo farmerProductRepository;

    public UpdateFarmProductServiceImpl(RegisterItemRepo farmerProductRepository) {
        this.farmerProductRepository = farmerProductRepository;
    }

    @Override
    @Transactional
    public boolean updateProduct(UpdateFarmerProductRequest request) {
        Optional<FarmerProduct> productOpt = farmerProductRepository.findByProductIdAndSellerId(request.getProduct().getCodeId(),request.getSellerId());
        if (!productOpt.isPresent()) {
            throw new ProductNotFoundException(
                    "Product with ID '" + request.getProduct().getCodeId() +
                            "' not found for seller ID: " + request.getSellerId()
            );
        }

        FarmerProduct product = productOpt.get();

        // ✅ Update quantity (if provided)

        if (request.getAchivedQuantity() != null && request.getEstimatedQuantity()==null && request.getAchivedQuantity()>0) {
            product.setAchivedQuantity(request.getAchivedQuantity());
        }

        if(request.getEstimatedQuantity() != null && request.getAchivedQuantity()==null && request.getEstimatedQuantity()>0){
            product.setEstimatedQuantity(request.getEstimatedQuantity());
        }

        // ✅ Update availability date (if provided)
        if (request.getUpdatedTimeStamp() != null) {
            product.setAvailabilityOn(request.getUpdatedTimeStamp().toLocalDate());
            product.setUpdatedTimeStamp(request.getUpdatedTimeStamp());
        }

        // ✅ Update product status string (Enum name)
        if (request.getProductStatus() != null) {
            FarmingStatusCode status = request.getProductStatus();
            product.setProductStatus(status.name());

            // ✅ Determine productState (active = 1, inactive = 0)
            int state = determineProductState(status);
            product.setProductState(state);
        }

        // ✅ Save to DB
        farmerProductRepository.save(product);
        return true;
    }

    public void callEmailService(FarmerProduct farmerProduct){

    }

    /**
     * Determines whether productState should be 0 (inactive) or 1 (active)
     * based on the lifecycle status of the product.
     */
    private int determineProductState(FarmingStatusCode status) {
        // Inactive (0) for failure or destroyed stages
        if (status == FarmingStatusCode.DISEASE_OUTBREAK
                || status == FarmingStatusCode.STORM_DAMAGE
                || status == FarmingStatusCode.DROUGHT_DAMAGE
                || status == FarmingStatusCode.WATER_CONTAMINATION
                || status == FarmingStatusCode.ACCIDENTAL_DEATH
                || status == FarmingStatusCode.LOCUST_ATTACK) {
            return 0;
        }
        return 1;
    }
}
