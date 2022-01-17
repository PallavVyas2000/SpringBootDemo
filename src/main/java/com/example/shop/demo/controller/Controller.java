package com.example.shop.demo.controller;

import java.util.List;

import com.example.shop.demo.entities.Products;
import com.example.shop.demo.services.ProductsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    //object for accessing ProductServices interface
    private ProductsServices productServices;

    @GetMapping("/home")
    public String home(){
        return "This is the HomePage";
    }

    // Method to get all the products available
    @GetMapping("/products")
    public List<Products> getProducts()
    {
        return this.productServices.getProducts();
    }
    // Method for searching specific product
    @GetMapping("/products/{productId}")
    public Products getProduct(@PathVariable String productId)
    {
        return this.productServices.getProduct(Long.parseLong(productId));
    }
    // Method to add an item into the database
    @PostMapping("/products")
    public Products addProduct(@RequestBody Products product)
    {
        return this.productServices.addProduct(product);
    }
    // Method for updating the product in the databse
    @PutMapping("/products")
    public Products updateProduct(@RequestBody Products product)
    {
        return this.productServices.updateProduct(product);
    }
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String productId)
    {
        try
        {
            this.productServices.deleteProduct(Long.parseLong(productId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
