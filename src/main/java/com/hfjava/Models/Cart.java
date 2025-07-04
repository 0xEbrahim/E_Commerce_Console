package com.hfjava.Models;

import com.hfjava.Interface.ICart;
import com.hfjava.Interface.IExpire;

import javax.xml.namespace.QName;
import java.util.*;

public class Cart implements ICart {
    private Set<Product> items;

    private Map<String, Integer> ItemCount;
    private double TotalPrice;
    Cart() {
        items = new HashSet<>();
        ItemCount = new HashMap<>();
        TotalPrice = 0;
    }

    @Override
    public void add(Product product, int quantity) {
        String name = product.getName();
        if (quantity > product.getQuantity()) {
            System.out.println("Insuffecient product quantity.");
            return;
        }
        if(product.getQuantity() == 0){
            throw new Error("Product is out of stock.");
        }
        if(product instanceof IExpire){
            if(((IExpire) product).isExpired()){
                throw new Error("Product is Expired.");
            }
        }
        if (ItemCount.containsKey(name)) {
            ItemCount.put(name, quantity + ItemCount.get(name));
        } else {
            items.add(product);
            ItemCount.put(name, quantity);
        }
        product.setQuantity(product.getQuantity() - quantity);
        this.TotalPrice += quantity * product.getPrice();
    }

    @Override
    public void decrease(Product product, int quantity) {
        if(!ItemCount.containsKey(product.getName())){
            System.out.println("Product is not exist on the cart. unable to decrease quantity.");
            return;
        }
        if(ItemCount.get(product.name) == 0){
            System.out.println("Product is not on the cart.");
        }
        if(product instanceof IExpire){
            if(((IExpire) product).isExpired()){
                throw new Error("Product is Expired.");
            }
        }
        if(quantity > product.getQuantity()){
            System.out.println("Insuffecient product quantity.");
            return;
        }
        ItemCount.put(product.getName(), ItemCount.get(product.getName()) - quantity);
        if(ItemCount.get(product.getName()) == 0){
            ItemCount.remove(product.getName());
            items.remove(product);
        }
        product.setQuantity(product.getQuantity() + quantity);
        this.TotalPrice -= quantity * product.getPrice();
    }

    @Override
    public void remove(Product product) {
        if(!ItemCount.containsKey(product.getName())){
            System.out.println("Product is not exist on the cart. unable to decrease quantity.");
            return;
        }
        product.setQuantity(product.getQuantity() + ItemCount.get(product.getName()));
        this.TotalPrice -= ItemCount.get(product.getName()) * product.getPrice();
        ItemCount.remove(product.getName());
        items.remove(product);
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public void clear() {
        ItemCount.clear();
        items.clear();
        TotalPrice = 0;
    }

    public Set<Product> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public Map<String, Integer> getItemCount() {
        return ItemCount;
    }

    public void showCart(){
        System.out.println("*** CART ***");
        for(Product product : items){
            System.out.println(this.ItemCount.get(product.getName())+"X " + product.getName());
        }
        System.out.println("__________________");
    }
}
