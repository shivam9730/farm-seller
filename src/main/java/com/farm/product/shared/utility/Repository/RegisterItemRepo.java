package com.farm.product.shared.utility.Repository;

import com.farm.product.shared.utility.entity.FarmerProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegisterItemRepo extends JpaRepository<FarmerProduct,Long> {
    Optional<FarmerProduct> findByProductIdAndSellerId(Long productId, Long sellerId);

    List<FarmerProduct> findBySellerId(Long sellerId);
    List<FarmerProduct> findByProductNameContainingIgnoreCase(String productName);
    boolean existsByProductNameAndSellerId(String productName, Long sellerId);

    boolean existsByProductIdAndSellerId(Long productId, Long sellerId);
}
