package com.examly.springapp.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.repository.PurchaseOrderRepo;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService{
    private final PurchaseOrderRepo purchaseorderrepo;
    public PurchaseOrderServiceImpl(PurchaseOrderRepo purchaseorderrepo){
        this.purchaseorderrepo=purchaseorderrepo;
    }

    public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder){
        return purchaseorderrepo.save(purchaseOrder);
    }
    public List<PurchaseOrder> getAllPurchaseOrders(){
        return purchaseorderrepo.findAll();
    }
    public PurchaseOrder getPurchaseOrderById(int purchaseOrderId){
        return purchaseorderrepo.findById(purchaseOrderId).orElse(null);
    }
    public PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrder,int purchaseOrderId){
        PurchaseOrder toBeUpdated=getPurchaseOrderById(purchaseOrderId);
        if(toBeUpdated==null) return null;
        toBeUpdated.setOrderNumber(purchaseOrder.getOrderNumber());
        toBeUpdated.setOrderDate(purchaseOrder.getOrderDate());
        toBeUpdated.setStatus(purchaseOrder.getStatus());
        toBeUpdated.setSupplier(purchaseOrder.getSupplier());
        return purchaseorderrepo.save(toBeUpdated);
    }
    public Boolean deletePurchaseOrder(int purchaseOrderId){
        PurchaseOrder toBeDeleted=getPurchaseOrderById(purchaseOrderId);
        if(toBeDeleted==null) return false;
        purchaseorderrepo.deleteById(purchaseOrderId);
        return true;
    }
}
