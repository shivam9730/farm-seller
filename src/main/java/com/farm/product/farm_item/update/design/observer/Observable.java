package com.farm.product.farm_item.update.design.observer;

public interface Observable {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
