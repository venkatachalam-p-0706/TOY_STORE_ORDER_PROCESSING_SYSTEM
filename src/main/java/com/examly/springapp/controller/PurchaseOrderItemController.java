package com.examly.springapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.service.PurchaseOrderItemService;

@RestController
@RequestMapping("/api/purchase-order-items")
public class PurchaseOrderItemController {
    private final PurchaseOrderItemService purorditemserv;
    public PurchaseOrderItemController(PurchaseOrderItemService purorditemserv){
        this.purorditemserv=purorditemserv;
    }
    @PostMapping
    public ResponseEntity<PurchaseOrderItem> addPurchaseOrderItem(@RequestBody PurchaseOrderItem purorditem){
        return ResponseEntity.status(201).body(purorditemserv.addPurchaseOrderItem(purorditem));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrderItem>> getAllPurchaseOrderItems(){
        return ResponseEntity.ok(purorditemserv.getAllPurchaseOrderItems());
    }
    @GetMapping("/{purchaseOrderItemId}")
    public ResponseEntity<PurchaseOrderItem> getPurchaseOrderItemById(@PathVariable int purchaseOrderItemId){
        return ResponseEntity.ok(purorditemserv.getPurchaseOrderItemById(purchaseOrderItemId));
    }  

    @PutMapping("/{purchaseOrderItemId}")
    public ResponseEntity<PurchaseOrderItem> updatePurchaseOrderItem(@RequestBody PurchaseOrderItem purorditem,@PathVariable int purchaseOrderItemId){
        return ResponseEntity.ok(purorditemserv.updatePurchaseOrderItem(purorditem,purchaseOrderItemId));
    }

    @DeleteMapping("/{purchaseOrderItemId}")
    public ResponseEntity<Boolean> deletePurchaseOrderItem(@PathVariable int purchaseOrderItemId){
        Boolean deleted=purorditemserv.deletePurchaseOrderItem(purchaseOrderItemId);
        if(deleted)
            return ResponseEntity.status(200).body(true);
        return ResponseEntity.status(404).body(false); 
    }

    @GetMapping("/order/{purchaseOrderId}")
    public ResponseEntity<List<PurchaseOrderItem>> getPurchaseOrderItemsByOrderId(@PathVariable int purchaseOrderId){
        return ResponseEntity.ok(purorditemserv.getPurchaseOrderItemsByOrderId(purchaseOrderId));
    }



}
