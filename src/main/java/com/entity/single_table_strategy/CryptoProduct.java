package com.entity.single_table_strategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue("crypto")
//@PrimaryKeyJoinColumn(name = "crypto_product_id")
public class CryptoProduct extends Product {

    private String blockchain;

    public CryptoProduct() {
    }

    public CryptoProduct(String name, double price, String blockchain) {
        super(name, price);
        this.blockchain = blockchain;
    }

    @Override
    public String toString() {
        return "CryptoProduct{" +
                "blockchain='" + blockchain + '\'' +
                '}';
    }
}
