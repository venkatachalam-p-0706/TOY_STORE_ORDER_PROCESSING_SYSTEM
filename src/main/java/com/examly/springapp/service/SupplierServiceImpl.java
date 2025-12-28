package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Supplier;
import com.examly.springapp.repository.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepo supprepo;
    public SupplierServiceImpl(SupplierRepo supprepo){
        this.supprepo=supprepo;
    }

    public Supplier addSupplier(Supplier supp){
        return supprepo.save(supp);
    }
    public List<Supplier> getAllSuppliers(){
        return supprepo.findAll();
    }
    public Supplier getSupplierById(int supplierId){
        return supprepo.findById(supplierId).orElse(null);
    }
    public Supplier updateSupplier(Supplier supp,int supplierId){
        Supplier toBeUpdated=getSupplierById(supplierId);
        if(toBeUpdated==null) return null;
        toBeUpdated.setSupplierName(supp.getSupplierName());
        toBeUpdated.setContactNumber(supp.getContactNumber());
        toBeUpdated.setEmail(supp.getEmail());
        toBeUpdated.setAddress(supp.getAddress());
        return supprepo.save(toBeUpdated);
    }
    public Boolean deleteSupplier(int supplierId){
        Supplier toBeDeleted=getSupplierById(supplierId);
        if(toBeDeleted==null) return false;
        supprepo.deleteById(supplierId);
        return true;
    }

    
}
