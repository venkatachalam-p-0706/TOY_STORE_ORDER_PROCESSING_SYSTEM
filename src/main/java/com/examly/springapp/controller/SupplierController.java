package com.examly.springapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.examly.springapp.model.Supplier;
import com.examly.springapp.service.SupplierService;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    SupplierService suppserv;
    public SupplierController(SupplierService suppserv){
        this.suppserv=suppserv;
    }
    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supp){
        return ResponseEntity.status(HttpStatus.CREATED).body(suppserv.addSupplier(supp));
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers(){
        return ResponseEntity.ok(suppserv.getAllSuppliers());
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int supplierId){
        return ResponseEntity.ok(suppserv.getSupplierById(supplierId));
    }

    @PutMapping("/{supplierId}")
    public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supp,@PathVariable int supplierId){
        return ResponseEntity.ok(suppserv.updateSupplier(supp,supplierId));
    }
}
