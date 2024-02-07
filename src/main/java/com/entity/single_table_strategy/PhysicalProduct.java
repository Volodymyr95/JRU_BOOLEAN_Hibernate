package com.entity.single_table_strategy;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue("physical")
//@PrimaryKeyJoinColumn(name = "physical_product_id")
public class PhysicalProduct extends Product {

    private double size;

    public PhysicalProduct() {
    }

    public PhysicalProduct(String name, double price, double size) {
        super(name, price);
        this.size = size;
    }

    @Override
    public String toString() {
        return "PhysicalProduct{" +
                "size=" + size +
                '}';
    }
}
