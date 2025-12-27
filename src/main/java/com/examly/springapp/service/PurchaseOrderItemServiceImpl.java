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

    public List<PurchaseOrderItem> getPurchaseOrderItemsByOrderId(int purchaseOrderId){
        return purorditemrepo.findByPurchaseOrder_PurchaseOrderId(purchaseOrderId);
    }
}
