# E_Commerce_Console


## Project structure
```
.
└── Program/
    ├── Interface/
    │   ├── ICart.java
    │   ├── IExpire.java
    │   └── IShipping.java
    ├── Models/
    │   ├── Biscuits.java
    │   ├── Card
    │   ├── Cart
    │   ├── Cheese
    │   ├── Customer
    │   ├── Product
    │   ├── ShippableProduct
    │   └── TV
    ├── Services/
    │   ├── CheckoutService.java
    │   ├── ShppingService.java
    │   └── SystemService.java
    └── Main.java
```

## Features
1 - Customers can signup Or login to the application
  - Customer's email must be unique, validataion added.

2 - Each customer has a preserved cart and he can
  - Add to cart
  - Decrease quantity of product of the cart
  - Remove from cart
  - Clear the cart
    
3 - Multi product types supported [Expirable | Shippable | Expirable and shippable]
  - Handled the different types using interface and used the interfaces to check the type of the instance, for example:
    ```
    public interface IShipping {
    String getName();
    double getWeight();
    }
    ```
    - This can be used to check if the product is shippable or not if the product implements it:
    ```
    if(product instaceOf IShipping){}
    ```
4 - Checkout service
  - Calculate the shipping fees
  - Calculate the total weight of the shipped products
  - calculate subTotal price & the total price

5 - Handling errors and corner cases
  - check if customer will be able to pay for the products [Check balance]
  - check if you can add this quantity of products to the cart [Check product quantity]
  - check if you can remove this quantity of product from the cart [Check product quantity on the cart] 
  - check if the product is expired or out of stock

6 - Application is built with strong object oriented programming structure utilized the most important concepts of it:
  - Inheratnce
  - Encapsulation
  - Polymorphism
  - Abstraction
