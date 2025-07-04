package com.hfjava;

import com.hfjava.Models.*;
import com.hfjava.Services.CheckoutService;
import com.hfjava.Services.SystemService;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to ecommerce app, please choose a choice.");
        Scanner sc = new Scanner(System.in);

        Customer customer = null;
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.SEPTEMBER, 15);
        Date date = cal.getTime();
        Cheese AbourLand = new Cheese("AbourLand Cheese", 70, 20, 500, date);
        cal.set(2025, Calendar.AUGUST, 17);
        date = cal.getTime();
        Cheese rhodes = new Cheese("rhodes Cheese", 65, 10, 490, date);
        TV toshiba = new TV("Toshiba TV", 1500, 14, 1500);
        Biscuits nawaaem = new Biscuits("Nawaaem Biscuit", 20, 6, 10, date);
        Card scartchedCard = new Card("Vodafone card", 15, 1);
        ArrayList<Product> products = new ArrayList<>();
        products.add(scartchedCard);
        products.add(AbourLand);
        products.add(rhodes);
        products.add(toshiba);
        products.add(nawaaem);
        start:
        while (true) {
            System.out.println("1 - signup");
            System.out.println("2 - login");
            int answer = sc.nextInt();
            if (answer == 1) {
                SystemService.signUp();
            } else if (answer == 2) {
                customer = SystemService.login();
                if (customer == null) {
                    System.out.println("Wrong email or password, please try again.");
                } else {
                    System.out.println("Welcome to the application " + customer.getName());
                    break;
                }
            } else {
                System.out.println("Please enter a valid choice, 1 or 2.");
            }
        }

        while (true) {
            System.out.println("Please choose a choice: ");
            System.out.println("1 - Explore Products");
            System.out.println("2 - Show Cart");
            System.out.println("3 - checkout");
            System.out.println("4 - logout");
            int answer = sc.nextInt();
            if (answer == 1) {
                System.out.println("Choose a product: ");
                int choice = -1;
                for (int i = 0; i < products.size(); i++) {
                    System.out.println(i + 1 + " - " + products.get(i).getName());
                }
                while (choice < 1 || choice > products.size() + 1) {
                    choice = sc.nextInt();
                    if (choice < 1 || choice > products.size() + 1)
                        System.out.println("Please enter a valid product choice.");
                }
                Product product = products.get(choice - 1);

                int choice2 = 0;
                while (choice2 <= 0 || choice2 > 3) {
                    System.out.println("Please choose a choice: ");
                    System.out.println("1 - Add to cart");
                    System.out.println("2 - decrease if in cart");
                    System.out.println("3 - remove from cart");
                    choice2 = sc.nextInt();
                    if (choice2 < 1 || choice2 > 3)
                        System.out.println("Please enter a valid product choice.");
                }
                if(choice2 == 1 || choice2 == 2){
                    System.out.println("Please enter the quantity.");
                    int quantity = sc.nextInt();
                    if (choice2 == 1) {
                        customer.getCart().add(product, quantity);
                    } else {
                        customer.getCart().decrease(product, quantity);
                    }
                }else {
                    customer.getCart().remove(product);
                }
            } else if (answer == 2) {
                customer.getCart().showCart();
            } else if (answer == 3) {
                CheckoutService.checkout(customer, customer.getCart());
                customer.getCart().clear();
            } else if(answer == 4){
                break;
            }else {
                System.out.println("Please enter a valid choice, 1, 2 or 3.");

            }
        }
    }
}