package com.github.nosachigor23.shoponline.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "storage_device")
public class StorageDeviceEntity extends AProductEntity implements Serializable {


	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "speed")
	private int speed;

	@Column(name = "discount")
	private int discount = getDiscount();


	public StorageDeviceEntity() {
		this.type = "storageDevice";

	}

	public StorageDeviceEntity(String manufacturer, int speed) {

		this.manufacturer = manufacturer;

		this.speed = speed;

	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
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
				", producing_country='" + producing_country + '\'' +
				'}';
	}

	@Override
	protected int calculateDiscountForProduct() {

		if (!day.matches("THURSDAY|FRIDAY|SATURADY")){

			return 0;

		}

		final int defaultValue = 10;

		final 	String manufacturer = getManufacturer();

		if (manufacturer.equalsIgnoreCase("kingston")) {

			return defaultValue / 2;

		}

		else if (manufacturer.equalsIgnoreCase("samsung")) {

			return defaultValue / 3;

		}

		else return defaultValue;

	}
}
