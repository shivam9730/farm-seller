package com.farm.product.shared.utility;

import com.farm.product.shared.utility.GlobalException.ProductNotFoundException;
import com.farm.product.shared.utility.Repository.CodeGroupDescRepository;
import com.farm.product.shared.utility.entity.CodeGroupDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Utility {

    @Autowired
    private CodeGroupDescRepository repository;

    public String getDescriptionById(Long id) {
        return Optional.ofNullable(repository.findByCodeId(id))
                .map(CodeGroupDesc::getDescription)
                .orElseThrow(() -> new ProductNotFoundException("Product is unregistered."));
    }
}
