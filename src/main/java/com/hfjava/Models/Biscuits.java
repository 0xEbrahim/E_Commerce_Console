package com.hfjava.Models;

import com.hfjava.Interface.IExpire;
import com.hfjava.Interface.IShipping;

import java.util.Date;

public class Biscuits extends ShippableProduct implements IExpire {
    final private Date expiryDate;

    public Biscuits(String name, double price, int quantity, double weight, Date expiryDate) {
        super(name, price, quantity, weight);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return new Date().after(expiryDate);
    }
}
