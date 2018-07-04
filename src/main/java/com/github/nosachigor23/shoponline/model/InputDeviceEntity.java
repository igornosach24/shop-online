package com.github.nosachigor23.shopOnline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "input_device")
public class InputDeviceEntity extends AProductEntity implements Serializable {
	
	private static final long serialVersionUID = -65951231237L;

	@Column(name = "color")
	private String color;

	@Column(name = "discount")
	private int discount;

	{
		this.type = "inputDevice";
	}

	public InputDeviceEntity() {

	}

	public InputDeviceEntity(String color) {

		this.color = color;

	}

	public String getColor() {
		return color;
	}

	/*

	Since the object is first created, and then the fields in the form of Thymeleaf are filled through the setters,
	the value of the discount will change with each change of the given field (in this case - 'color').

	 */

	public void setColor(String color) {
		this.color = color;
		this.discount = calculateDiscountForProduct();
	}
	public int getDiscount() {
		return this.discount;
	}

	/*

	For input device with pink color price equals '40'%;

	 */

	@Override
	public String toString() {
		return "InputDevice{" +
				"color='" + color + '\'' +
				", discount=" + discount +
				'}';
	}

	@Override
	protected int calculateDiscountForProduct() {
		if (!day.matches("TUESDAY|WEDNESDAY")) {
			return 0;
		}
		if (getColor().equalsIgnoreCase("pink")) {
			return 40;
		} else {
			return DEFAULT_DISCOUNT_FOR_ALL_PRODUCTS;
		}
	}
}
