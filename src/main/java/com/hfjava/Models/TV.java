package com.hfjava.Models;

import com.hfjava.Interface.IShipping;

public class TV extends ShippableProduct {
    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity, weight);
    }
}
