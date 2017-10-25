package com.github.nosachigor23.shoponline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "peripherals")
public class PeripheralsEntity extends AProductEntity implements Serializable {

    @Column(name = "kind")
    private String kind;

    @Column(name = "info")
    private String info;

    @Column(name = "discount")
    private int discount;

    {
        this.type = "peripherals";

    }

    public PeripheralsEntity() {
        this.discount = calculateDiscount(this);
    }

    public PeripheralsEntity(String kind, String info) {
        this.kind = kind;
        this.info = info;

    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getDiscount() {
        return discount;
    }


    @Override
    public String toString() {

        return "PeripheralsEntity{" +
                ", id=" + id +
                "kind='" + kind + '\'' +
                ", info='" + info + '\'' +
                ", discount=" + discount +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", producing_country='" + producing_country + '\'' +
                ", price=" + price +
                '}';
    }
}
