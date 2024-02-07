package com.entity.single_table_strategy;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue("digital")
//@PrimaryKeyJoinColumn(name = "digital_product_id")
@Polymorphism(type = PolymorphismType.EXPLICIT)
public class DigitalProduct extends Product {

    private String link;

    public DigitalProduct() {
    }

    public DigitalProduct(String name, double price, String link) {
        super(name, price);
        this.link = link;
    }

    @Override
    public String toString() {
        return "DigitalProduct{" +
                "link='" + link + '\'' +
                '}';
    }
}
