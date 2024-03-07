package com.lcorp.shoppyservice.model;

import jakarta.persistence.*;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String supplierName;

    public Supplier() {

    }

    public Supplier(String supplierName) {
        this.supplierName = supplierName;
    }

    public long getId() {
        return id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
