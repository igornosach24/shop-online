package com.github.nosachigor23.shoponline.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "display")
public class DisplayEntity extends AProductEntity implements Serializable {

	private static final long serialVersionUID = -659550364568648117L;

	@Column(name = "diagonal")
	private int diagonal;

	@Column(name = "model")
	private String model;

	@Column(name = "discount")
	private int discount;

	{
		this.type = "display";
	}

	public DisplayEntity() {

	}

	public DisplayEntity(int diagonal, String model) {

		this.diagonal = diagonal;

		this.model = model;

	}

	public int getDiagonal() {
		return diagonal;
	}

	/*

	Since the object is first created, and then the fields in the form of Thymeleaf are filled through the setters,
	the value of the discount will change with each change of the given field (in this case -

	 */

	public void setDiagonal(int diagonal) {

		this.diagonal = diagonal;

		this.discount = calculateDiscountForProduct();

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

	public String getType() {
		return type;
	}

	/*
	The discount depends on the diagonal of the screen.
	 */
	@Override
	public String toString() {
		return "Display{" +
				"diagonal=" + diagonal +
				", model='" + model + '\'' +
				", discount=" + discount +
				'}';
	}

	@Override
	protected int calculateDiscountForProduct() {
		return this.diagonal;
	}
}
