package com.example.shop.demo.services;

import java.util.List;

import com.example.shop.demo.entities.Products;

public interface ProductsServices {
    public List<Products> getProducts();
    public Products getProduct(long productId);
    public Products addProduct(Products product);
    public Products updateProduct(Products product);
    public void deleteProduct(long parseLong);
}
