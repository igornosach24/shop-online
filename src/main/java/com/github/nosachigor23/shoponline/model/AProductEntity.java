package com.github.nosachigor23.shoponline.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AProductEntity extends ABaseDaoEntity implements Serializable {

    private static final long serialVersionUID = -695503064509648117L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected int id;

    protected int amount;

    protected String type;

    protected String producing_country;

    protected int price;

    protected int discount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    protected void setType(ProductType type) {
        this.type = ProductType.convertEnumToString(type);
    }

    public String getProducing_country() {
        return producing_country;
    }

    public void setProducing_country(String producing_country) {
        this.producing_country = producing_country;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
