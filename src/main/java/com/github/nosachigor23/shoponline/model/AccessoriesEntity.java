package com.github.nosachigor23.shoponline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "accessories")
public class AccessoriesEntity extends AProductEntity implements Serializable {

	private static final long serialVersionUID = -65957457668648117L;
	
	@Column(name = "info")
	private String info;

	@Column(name = "kind")
	private String kind;

	@Column(name = "discount")
	private int discount = calculateDiscountForProduct();

	{
		this.type = "accessories";
	}

	public AccessoriesEntity() {
	}

	public AccessoriesEntity(String info, String kind) {

		this.info = info;

		this.kind = kind;

	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	/*

    For accessories, the discount is equal to the default value

	 */

	@Override
	protected int calculateDiscountForProduct() {

		if (!day.matches("SUNDAY|MONDAY|FRIDAY")) {

			return 0;

		}

		return DEFAULT_DISCOUNT_FOR_ALL_PRODUCTS;

	}

	@Override
	public String toString() {
		return "Accessories{" +
				"info='" + info + '\'' +
				", kind='" + kind + '\'' +
				", discount=" + discount +
				'}';
	}
}
