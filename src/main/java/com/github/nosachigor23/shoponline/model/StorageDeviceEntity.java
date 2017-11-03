package com.github.nosachigor23.shoponline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "storage_device")
public class StorageDeviceEntity extends AProductEntity implements Serializable {
	
	private static final long serialVersionUID = -12303645617L;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "speed")
	private int speed;

	@Column(name = "discount")
	private int discount;

	{
		this.type = "storage_device";
	}

	public StorageDeviceEntity() {

	}

	public StorageDeviceEntity(String manufacturer, int speed) {

		this.manufacturer = manufacturer;

		this.speed = speed;

	}

	public String getManufacturer() {
		return manufacturer;
	}

	/*

	Since the object is first created, and then the fields in the form of Thymeleaf are filled through the setters,
	the value of the discount will change with each change of the given field (in this case - 'manufacturer').

	 */

	public void setManufacturer(String manufacturer) {

		this.manufacturer = manufacturer;

		this.discount = calculateDiscountForProduct();

	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDiscount() {
		return discount;
	}

	@Override
	public String toString() {

		return "StorageDevice{" +
				"manufacturer='" + manufacturer + '\'' +
				", speed=" + speed +
				", discount=" + discount +
				'}';

	}

	@Override
	protected int calculateDiscountForProduct() {

		if (!day.matches("THURSDAY|FRIDAY|SATURADY")) {

			return 0;

		}

		final int defaultValue = 10;

		final String manufacturer = getManufacturer();

		if (manufacturer.equalsIgnoreCase("kingston")) {

			return defaultValue / 2;

		} else if (manufacturer.equalsIgnoreCase("samsung")) {

			return defaultValue / 3;

		} else return defaultValue;

	}
}
