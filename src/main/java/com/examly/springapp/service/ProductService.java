package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import java.util.*;

public interface ProductService {
    public Product addProduct(Product prod);
    public List<Product> getAllProducts();
    public Product getProductById(int productId);
    public Product updateProduct(Product prod,int productId);

}
