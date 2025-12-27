package com.examly.springapp.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo prodrepo;
    public ProductServiceImpl(ProductRepo prodrepo){
        this.prodrepo=prodrepo;
    } 
    

    public Product addProduct(Product prod){
        return prodrepo.save(prod);
    }

    public List<Product> getAllProducts(){
        return prodrepo.findAll();
    }

    public Product getProductById(int productId){
        return prodrepo.findById(productId).orElse(null);
    }

    public Product updateProduct(Product prod,int productId){
        Product prodToBeUpdated=getProductById(productId);
        if(prodToBeUpdated==null) return null;
        prodToBeUpdated.setProductName(prod.getProductName());
        prodToBeUpdated.setDescription(prod.getDescription());
        prodToBeUpdated.setPrice(prod.getPrice());
        prodToBeUpdated.setStockQuantity(prod.getStockQuantity());
        return prodrepo.save(prodToBeUpdated);
    }
}
