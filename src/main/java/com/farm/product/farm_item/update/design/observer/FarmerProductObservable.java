package com.farm.product.farm_item.update.design.observer;

import com.farm.product.shared.utility.Utility;
import com.farm.product.shared.utility.entity.ContactDetails;

import java.util.ArrayList;
import java.util.List;

public class FarmerProductObservable implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private List<ContactDetails> contactDetailsList = new ArrayList<>();
    private final Utility utility;

    public FarmerProductObservable(Utility utility) {
        this.utility = utility;
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            ContactDetails contactDetails = utility.getContactDetailsById(observer.getConsumerId());
            contactDetailsList.add(contactDetails);
        }
        /**
         * Call email service with contactDetailsList to notify users
         * Param : contactDetailsList, emailTemplateName
         */

    }
}
