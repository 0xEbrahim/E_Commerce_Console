package com.hfjava.Models;

public class Customer {
    private String name, email, password;
    private double balance;
    Cart cart;
    public Customer(String name, String email, String password, double balance){
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public Cart getCart() {
        return cart;
    }
}
