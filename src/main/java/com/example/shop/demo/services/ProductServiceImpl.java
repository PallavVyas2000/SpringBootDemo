package com.example.shop.demo.services;

// import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;

import com.example.shop.demo.dao.ProductDao;
import com.example.shop.demo.entities.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements ProductsServices{
    //creating object for database interface
    @Autowired
    private ProductDao productDao;
    //creating a list for returning it to the interface
    
    // List<Products> products;
    public ProductServiceImpl() {
        // products = new ArrayList<>();
        // products.add(new Products(1,"Mouse","High Quality Mouse"));
        // products.add(new Products(2,"Keyboard","Mechanical Keyboard"));
    }

    @Override
    public List<Products> getProducts() {
        //returning list
        return productDao.findAll();
    }
    @Override
    public Products getProduct(long productId)
    {
        // Products p = null;
        // for(Products product:products)
        // {    //comparing recieved productId with id's in list using product variable
        //     if(product.getId()==productId)
        //     {
        //         p = product;
        //         break;
        //     }
        // }
        return productDao.getById(productId);
    }

    @Override
    public Products addProduct(Products product) {
        //adding recieved product
        // products.add(product);
        productDao.save(product);
        return product;
    }
    @Override
    public Products updateProduct(Products product) {
        // products.forEach(e -> {
        //     if(e.getId()==product.getId())
        //     {
        //         //matching the id of the product and updating the value
        //         e.setName(product.getName());
        //         e.setDescription(product.getDescription());
        //     }
        // }
    // );
        productDao.save(product);
        return product;
    }
    @Override
    public void deleteProduct(long parseLong) {
        // this statement creates a new list of all elements which do not match with the recieved productId and replaces the old list with the new list
        // products=this.products.stream().filter(p -> p.getId()!=parseLong).collect(Collectors.toList());
        Products entity = productDao.getById(parseLong);
        productDao.delete(entity);
    }
}
