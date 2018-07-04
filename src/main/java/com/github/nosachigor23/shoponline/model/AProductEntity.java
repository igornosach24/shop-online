package com.github.nosachigor23.shopOnline.model;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class   AProductEntity implements Serializable {

	private static final long serialVersionUID = -695503064509648117L;

	@Transient
	protected final int DEFAULT_DISCOUNT_FOR_ALL_PRODUCTS = 5;

	@Transient
	protected final DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();

	@Transient
	protected final String day = dayOfWeek.name();  // The current day of the week

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

	/*

	The discount depends on the day of the week and some characteristics of the goods,
	must be implemented in subclasses.

	 */

	protected abstract int calculateDiscountForProduct();

}
