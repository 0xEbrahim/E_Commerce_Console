package com.hfjava.Models;

import com.hfjava.Interface.IExpire;
import com.hfjava.Interface.IShipping;

import java.util.Date;

public class Cheese extends ShippableProduct implements IExpire {
    final private double weight;
    final private Date expiryDate;
    public Cheese(String name, double price, int quantity, double weight, Date expiryDate) {
        super(name, price, quantity, weight);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public double getWeight() {
       return this.weight;
    }

    @Override
    public boolean isExpired() {
        return new Date().after(expiryDate);
    }
}
