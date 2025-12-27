package com.examly.springapp.service;
import java.util.*;
import com.examly.springapp.model.PurchaseOrder;

public interface PurchaseOrderService {
    public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder);
    public List<PurchaseOrder> getAllPurchaseOrders();
    public PurchaseOrder getPurchaseOrderById(int purchaseOrderId);
    public PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrder,int purchaseOrderId);
}
