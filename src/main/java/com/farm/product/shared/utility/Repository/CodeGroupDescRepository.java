package com.farm.product.shared.utility.Repository;

import com.farm.product.shared.utility.entity.CodeGroupDesc;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CodeGroupDescRepository extends JpaRepository<CodeGroupDesc, Long> {
    CodeGroupDesc findByCodeId(Long idValue);
}
