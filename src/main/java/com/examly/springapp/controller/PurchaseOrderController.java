package com.examly.springapp.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.service.PurchaseOrderService;


@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {
    PurchaseOrderService purchaseordserv;
    public PurchaseOrderController(PurchaseOrderService purchaseordserv){
        this.purchaseordserv=purchaseordserv;
    }
    @PostMapping
    public ResponseEntity<PurchaseOrder> addPurchaseOrder(@RequestBody PurchaseOrder purchaseord){
        return ResponseEntity.status(201).body(purchaseordserv.addPurchaseOrder(purchaseord));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders(){
        return ResponseEntity.ok(purchaseordserv.getAllPurchaseOrders());
    }

    @GetMapping("/{purchaseOrderId}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable int purchaseOrderId){
        return ResponseEntity.ok(purchaseordserv.getPurchaseOrderById(purchaseOrderId));
    }
    
    @PutMapping("/{purchaseOrderId}")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(@RequestBody PurchaseOrder purchaseord,@PathVariable int purchaseOrderId){
        return ResponseEntity.ok(purchaseordserv.updatePurchaseOrder(purchaseord,purchaseOrderId));
    }
    @DeleteMapping("/{purchaseOrderId}")
    public ResponseEntity<Boolean> deletePurchaseOrder(@PathVariable int purchaseOrderId){
        Boolean deleted=purchaseordserv.deletePurchaseOrder(purchaseOrderId);
        if(deleted)
            return ResponseEntity.status(200).body(true);
        return ResponseEntity.status(404).body(false); 
    }

    
}
