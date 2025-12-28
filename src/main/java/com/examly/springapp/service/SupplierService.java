package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Supplier;


public interface SupplierService {
    public Supplier addSupplier(Supplier supp);
    public List<Supplier> getAllSuppliers();
    public Supplier getSupplierById(int supplierId);
    public Supplier updateSupplier(Supplier supp,int supplierId);
    public Boolean deleteSupplier(int supplierId);
}
