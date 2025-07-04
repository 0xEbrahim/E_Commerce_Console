package com.hfjava.Services;

import com.hfjava.Models.Cart;
import com.hfjava.Models.Customer;
import com.hfjava.Models.Product;
import com.hfjava.Models.ShippableProduct;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class CheckoutService {

    public static void checkout(Customer customer, Cart cart){
        if(cart.isEmpty()){
            throw new Error("Cart is Empty.");
        }
        if(cart.getTotalPrice() > customer.getBalance()){
            throw new Error("Customer's balance is insufficient");
        }
        ArrayList<ShippableProduct> shippableProducts = new ArrayList<>();
        for(Product product : cart.getItems()){
            if(product instanceof ShippableProduct){
                shippableProducts.add((ShippableProduct) product);
            }
        }
        ShippingService.shippingNotes(shippableProducts, cart);
        System.out.println();
        System.out.println("** Checkout receipt **");
        Set<Product> items = cart.getItems();
        Map<String, Integer> itemCount = cart.getItemCount();
        double subTotalPrice = 0;
        int shippedCount = 0;
        for(Product item : items){
            System.out.println(itemCount.get(item.getName())+"X " + item.getName() + "         " + item.getPrice() * itemCount.get(item.getName()));
            subTotalPrice += item.getPrice() * itemCount.get(item.getName());
            shippedCount += itemCount.get(item.getName());
        }
        System.out.println( "-----------------------------------");
        double shippingFees = shippedCount * 10;
        System.out.println("Subtotal              " + subTotalPrice);
        System.out.println("Shipping              " + shippingFees);
        double amount = subTotalPrice + shippingFees;
        System.out.println("Amount                " + amount);
        customer.setBalance(customer.getBalance() - amount);
        System.out.println("Your current balance: " + customer.getBalance());
    }
}
