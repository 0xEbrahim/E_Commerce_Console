package com.hfjava.Services;

import com.hfjava.Models.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemService {
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    static private final Scanner sc = new Scanner(System.in);

   public static void signUp(){
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        String email;
        while (true) {
            System.out.print("Enter your email: ");
            email = sc.nextLine().toLowerCase();
            if (!emailExist(email)) {
                break;
            } else {
                System.out.println("This email is already registered. Please use a different email.");
            }
        }

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        double balance = -1;
        while (balance < 0) {
            System.out.print("Enter your balance 0-9999: ");
            if (sc.hasNextDouble()) {
                balance = sc.nextDouble();
                sc.nextLine();
                if (balance < 0) {
                    System.out.println("Balance cannot less than 0.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }

        Customer customer = new Customer(name, email,password,balance);
        customers.add(customer);
        System.out.println("You have been registered.");
    }
public static Customer login(){
    System.out.print("Enter your email: ");
    String email = sc.nextLine().toLowerCase();
    System.out.print("Enter your password: ");
    String password = sc.nextLine();
    for(Customer customer: customers){
        if(customer.getEmail().equalsIgnoreCase(email) && customer.getPassword().equals(password)){
            return customer;
        }
    }
    return null;
}
    static boolean emailExist(String email){
        for(Customer customer : customers){
            if(customer.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
}
