package com.examly.springapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.service.CustomerReturnService;

@RestController
@RequestMapping("/api/customer-returns")
public class CustomerReturnController {

    private final CustomerReturnService customretserv;

    public CustomerReturnController(CustomerReturnService customretserv){
        this.customretserv=customretserv;
    }

    @PostMapping
    public ResponseEntity<CustomerReturn> addCustomerReturn(@RequestBody CustomerReturn customret){
        return ResponseEntity.status(201).body(customretserv.addCustomerReturn(customret));
    }

    @GetMapping
    public ResponseEntity<List<CustomerReturn>> getAllCustomerReturn(){
        return ResponseEntity.ok(customretserv.getAllCustomerReturn());
    }
    
    @GetMapping("/{customerReturnId}")
    public ResponseEntity<CustomerReturn> getCustomerReturnById(@PathVariable int customerReturnId){
        return ResponseEntity.ok(customretserv.getCustomerReturnById(customerReturnId));
    }
    
}
