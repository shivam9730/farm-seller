package com.choice.reigster.shared.utility.Repository;

import com.choice.reigster.shared.utility.entity.RegisterItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface RegisterItemRepo extends JpaRepository<RegisterItem,Long> {
    List<RegisterItem> findBySellerId(Long sellerId);
    List<RegisterItem> findByProductNameContainingIgnoreCase(String productName);
    boolean existsByProductNameAndSellerId(String productName, Long sellerId);

    boolean existsByProductIdAndSellerId(Long productId, Long sellerId);
}
