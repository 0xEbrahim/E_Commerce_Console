package com.hfjava.Models;

import com.hfjava.Interface.IShipping;

public abstract class ShippableProduct extends Product implements IShipping {
    private double weight;
    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
