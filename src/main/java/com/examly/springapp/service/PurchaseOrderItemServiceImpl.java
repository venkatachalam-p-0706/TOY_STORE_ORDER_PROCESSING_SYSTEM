package com.examly.springapp.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.repository.PurchaseOrderItemRepo;

@Service
public class PurchaseOrderItemServiceImpl implements PurchaseOrderItemService {

    private final PurchaseOrderItemRepo purorditemrepo;

    public PurchaseOrderItemServiceImpl(PurchaseOrderItemRepo purorditemrepo){
        this.purorditemrepo=purorditemrepo;
    }

    public PurchaseOrderItem addPurchaseOrderItem(PurchaseOrderItem purorditem){
        return purorditemrepo.save(purorditem);
    }
    public List<PurchaseOrderItem> getAllPurchaseOrderItems(){
        return purorditemrepo.findAll();
    }
    public PurchaseOrderItem getPurchaseOrderItemById(int purchaseOrderItemId){
        return purorditemrepo.findById(purchaseOrderItemId).orElse(null);
    }
    public PurchaseOrderItem updatePurchaseOrderItem(PurchaseOrderItem purorditem,int purchaseOrderItemId){
        PurchaseOrderItem toBeUpdated=getPurchaseOrderItemById(purchaseOrderItemId);
        if(toBeUpdated==null) return null;
        toBeUpdated.setPurchaseOrder(purorditem.getPurchaseOrder());
        toBeUpdated.setProduct(purorditem.getProduct());
        toBeUpdated.setQuantity(purorditem.getQuantity());
        toBeUpdated.setUnitPrice(purorditem.getUnitPrice());
        return purorditemrepo.save(toBeUpdated);
    }
    public Boolean deletePurchaseOrderItem(int purchaseOrderItemId){
        PurchaseOrderItem toBeDeleted=getPurchaseOrderItemById(purchaseOrderItemId);
        if(toBeDeleted==null) return false;
        purorditemrepo.deleteById(purchaseOrderItemId);
        return true;
    }

    public List<PurchaseOrderItem> getPurchaseOrderItemsByOrderId(int purchaseOrderId){
        return purorditemrepo.findByPurchaseOrder_PurchaseOrderId(purchaseOrderId);
    }
}
