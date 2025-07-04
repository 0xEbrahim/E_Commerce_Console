package com.hfjava.Services;

import com.hfjava.Interface.IShipping;
import com.hfjava.Models.Cart;
import com.hfjava.Models.Product;
import com.hfjava.Models.ShippableProduct;

import java.util.ArrayList;
import java.util.Map;

public class ShippingService {
    static void shippingNotes(ArrayList<ShippableProduct> shippedItems, Cart cart) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        double currentWeight = 0;
        Map<String, Integer> itemCount = cart.getItemCount();
        for (ShippableProduct product : shippedItems) {
            currentWeight = (product.getWeight() * itemCount.get(product.getName())) / 1000;
            String outPutWeight = currentWeight + "kg";
            totalWeight += currentWeight;
            if (currentWeight < 1.0) {
                currentWeight *= 1000;
                outPutWeight = currentWeight + "g";
            }
            System.out.println(itemCount.get(product.getName()) + "X " + product.getName() + "         " + outPutWeight);
        }
        String outputWeight = totalWeight + "kg";
        if (totalWeight < 1.0) {
            totalWeight *= 1000;
            outputWeight = totalWeight + "g";
        }
        System.out.println("Total package weight " + outputWeight);
    }
}
