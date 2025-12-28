package com.examly.springapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.examly.springapp.model.Product;
import com.examly.springapp.service.ProductService;



@RestController
@RequestMapping("/api/products")
public class ProductController{
    private final ProductService prodserv;
    public ProductController(ProductService prodserv){
        this.prodserv=prodserv;
    }
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product prod){
        Product created= prodserv.addProduct(prod);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products=prodserv.getAllProducts();
        if(products.isEmpty())
            return ResponseEntity.status(204).build();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId){
        return ResponseEntity.ok(prodserv.getProductById(productId));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product prod, @PathVariable int productId){
        return ResponseEntity.ok(prodserv.updateProduct(prod,productId));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable int productId){
        Boolean deleted=prodserv.deleteProduct(productId);
        if(deleted)
            return ResponseEntity.status(200).body(true);
        return ResponseEntity.status(404).body(false);

    }

   
}
