package com.examly.springapp.service;
import java.util.List;
import com.examly.springapp.model.PurchaseOrderItem;

public interface PurchaseOrderItemService {
    
    public PurchaseOrderItem addPurchaseOrderItem(PurchaseOrderItem purorditem);
    public List<PurchaseOrderItem> getAllPurchaseOrderItems();
    public PurchaseOrderItem getPurchaseOrderItemById(int purchaseOrderItemId);
    public PurchaseOrderItem updatePurchaseOrderItem(PurchaseOrderItem purorditem,int purchaseOrderItemId);
    public Boolean deletePurchaseOrderItem(int purchaseOrderItemId);

    public List<PurchaseOrderItem> getPurchaseOrderItemsByOrderId(int purchaseOrderId);

}
