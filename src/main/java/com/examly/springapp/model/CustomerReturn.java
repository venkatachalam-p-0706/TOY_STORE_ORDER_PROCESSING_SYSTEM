package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CustomerReturn {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer customerReturnId;
    private String returnDate;
    private String reason;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    public Integer getCustomerReturnId() {
        return customerReturnId;
    }

    public void setCustomerReturnId(Integer customerReturnId) {
        this.customerReturnId = customerReturnId;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CustomerReturn(String returnDate, String reason, Integer quantity, Product product) {
        this.returnDate = returnDate;
        this.reason = reason;
        this.quantity = quantity;
        this.product = product;
    }

    public CustomerReturn(){}

}
