package com.github.nosachigor23.shoponline.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "display")
@DiscriminatorValue("display")
public class DisplayEntity extends AProductEntity implements Serializable {

    private static final long serialVersionUID = -659550364568648117L;


    @Column(name = "diagonal")
    private int diagonal;

    @Column(name = "model")
    private String model;

    @Column(name = "discount")
    private int discount;

    {


    }
    public DisplayEntity() {
        this.type = "display";

    }

    public DisplayEntity(int diagonal, String model) {
        this.type = "display";

        this.diagonal = diagonal;
        this.model = model;


    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public String getType() {
        return "display";
    }

    @Override
    public String toString() {
        return "DisplayEntity{" +
                ", id=" + id +
                "diagonal=" + diagonal +
                ", model='" + model + '\'' +
                ", discount=" + discount +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", producing_country='" + producing_country + '\'' +
                ", price=" + price +
                '}';
    }
}
