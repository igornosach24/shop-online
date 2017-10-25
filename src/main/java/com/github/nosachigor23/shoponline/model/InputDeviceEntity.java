package com.github.nosachigor23.shoponline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "input_device")

public class InputDeviceEntity extends AProductEntity implements Serializable {

    @Column(name = "color")
    private String color;

    @Column(name = "discount")
    private int discount;

    public InputDeviceEntity() {
        this.type = "inputDevice";

    }

    public InputDeviceEntity(String color) {
        this.type = "inputDevice";


        this.color = color;

    }
    {

    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDiscount() {
        return this.discount;
    }



    @Override
    public String toString() {
        return ", id=" + id +
                "InputDeviceEntity{" +
                "color='" + color + '\'' +
                ", discount=" + discount +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", producing_country='" + producing_country + '\'' +
                ", price=" + price +
                '}';
    }
}
