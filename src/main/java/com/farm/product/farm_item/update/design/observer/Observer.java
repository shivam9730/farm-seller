package com.farm.product.farm_item.update.design.observer;
import com.farm.product.farm_item.update.design.UpdatedItemDetails;
import com.farm.product.shared.utility.entity.ContactDetails;

import java.util.Optional;
public interface Observer {
    public Long getConsumerId();
    public void updateConsumer(ContactDetails contactDetails, Optional<UpdatedItemDetails> updatedItemDetails);
}