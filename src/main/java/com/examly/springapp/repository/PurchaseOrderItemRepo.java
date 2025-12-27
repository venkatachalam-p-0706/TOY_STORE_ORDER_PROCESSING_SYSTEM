package com.examly.springapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.examly.springapp.model.PurchaseOrderItem;

@Repository
public interface PurchaseOrderItemRepo extends JpaRepository<PurchaseOrderItem,Integer>{
    public List<PurchaseOrderItem> findByPurchaseOrder_PurchaseOrderId(int purchaseOrderId);
    
}
