package com.farm.product.shared.utility;

import com.farm.product.shared.utility.GlobalException.ProductNotFoundException;
import com.farm.product.shared.utility.Repository.CodeGroupDescRepository;
import com.farm.product.shared.utility.Repository.ContactDetailsRepository;
import com.farm.product.shared.utility.entity.ContactDetails;
import com.farm.product.shared.utility.entity.CodeGroupDesc;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Utility {

    private final CodeGroupDescRepository codeGroupDescRepository;
    private final ContactDetailsRepository contactDetailsRepository;

    public Utility(CodeGroupDescRepository codeGroupDescRepository, ContactDetailsRepository contactDetailsRepository) {
        this.codeGroupDescRepository = codeGroupDescRepository;
        this.contactDetailsRepository = contactDetailsRepository;
    }

    public String getDescriptionById(Long id) {
        return Optional.ofNullable(codeGroupDescRepository.findByCodeId(id))
                .map(CodeGroupDesc::getDescription)
                .orElseThrow(() -> new ProductNotFoundException("Product is unregistered."));
    }

    public ContactDetails getContactDetailsById(Long id) {
        ContactDetails contactDetails = contactDetailsRepository.findByUserId(id)
                .orElseThrow(() -> new ProductNotFoundException("Contact details not found for the given ID."));
        if (contactDetails == null) {
            throw new ProductNotFoundException("Contact details not found for the given ID.");
        }
        return contactDetails;
    }
}
