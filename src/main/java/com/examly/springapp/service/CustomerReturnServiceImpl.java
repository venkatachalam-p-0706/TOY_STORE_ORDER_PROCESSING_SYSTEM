package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.repository.CustomerReturnRepo;

@Service
public class CustomerReturnServiceImpl implements CustomerReturnService{
    private final CustomerReturnRepo customerretrepo;
    public CustomerReturnServiceImpl(CustomerReturnRepo customerretrepo){
        this.customerretrepo=customerretrepo;
    }

    public CustomerReturn addCustomerReturn(CustomerReturn customret){
        return customerretrepo.save(customret);
    }

    public List<CustomerReturn> getAllCustomerReturn(){
        return customerretrepo.findAll();
    }

    public CustomerReturn getCustomerReturnById(int customerReturnId){
        return customerretrepo.findById(customerReturnId).orElse(null);
    }
    
    public CustomerReturn updateCustomerReturn(CustomerReturn customret,int customerReturnId){
        CustomerReturn toBeUpdated=getCustomerReturnById(customerReturnId);
        if(toBeUpdated==null) return null;
        toBeUpdated.setReturnDate(customret.getReturnDate());
        toBeUpdated.setReason(customret.getReason());
        toBeUpdated.setQuantity(customret.getQuantity());
        toBeUpdated.setProduct(customret.getProduct());
        return customerretrepo.save(toBeUpdated);
    }
    public Boolean deleteCustomerReturn(int customerReturnId){
        CustomerReturn toBeDeleted=getCustomerReturnById(customerReturnId);
        if(toBeDeleted==null) return false;
        customerretrepo.deleteById(customerReturnId);
        return true;
    }
}
