package com.farm.product.shared.utility.Repository;

import com.farm.product.shared.utility.entity.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails,Long> {
    Optional<ContactDetails> findByUserId(Long userId);
}
