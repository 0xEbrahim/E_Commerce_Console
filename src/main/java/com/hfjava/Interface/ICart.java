package com.hfjava.Interface;

import com.hfjava.Models.Product;

public interface ICart {
    void add(Product product,  int quantity);
    void decrease(Product product, int quantity);
    void remove(Product product);
    boolean isEmpty();
    void clear();
}
