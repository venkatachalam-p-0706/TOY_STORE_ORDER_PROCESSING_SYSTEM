package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.CustomerReturn;

public interface CustomerReturnService {
    public CustomerReturn addCustomerReturn(CustomerReturn customret);
    public List<CustomerReturn> getAllCustomerReturn();
    public CustomerReturn getCustomerReturnById(int customerReturnId);
    public CustomerReturn updateCustomerReturn(CustomerReturn customret,int customerReturnId);
    public Boolean deleteCustomerReturn(int customerReturnId);
}
