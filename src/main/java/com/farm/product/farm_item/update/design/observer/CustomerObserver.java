package com.farm.product.farm_item.update.design.observer;

import com.farm.product.farm_item.update.design.UpdatedItemDetails;
import com.farm.product.shared.utility.entity.ContactDetails;
import lombok.Data;

import java.util.Optional;

@Data
public class CustomerObserver implements Observer{

    private Observable farmerProductObservable;
    private Long consumerId;
    public CustomerObserver(Observable farmerProductObservable) {
        this.farmerProductObservable = farmerProductObservable;
        farmerProductObservable.addObserver(this);
    }

    @Override
    public void updateConsumer(ContactDetails contactDetails, Optional<UpdatedItemDetails> updatedItemDetails) {

    }
    @Override
    public Long getConsumerId() {
        return consumerId; // Return the consumerId
    }
}
