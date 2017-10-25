package com.github.nosachigor23.shoponline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "accessories")
public class AccessoriesEntity extends AProductEntity implements Serializable {

	@Column(name = "info")
	private String info;

	@Column(name = "kind")
	private String kind;

	@Column(name = "discount")
	private int discount = getDiscount();

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

	public int getDiscount() {
		return discount;
	}

	/*

    For accessories, the discount is equal to the default value

	 */

	@Override
	protected int calculateDiscountForProduct() {

		if(!day.matches("SUNDAY|MONDAY|FRIDAY")){

			return 0;

		}

		return DEFAULT_DISCOUNT_FOR_ALL_PRODUCTS;

	}

	@Override
	public String toString() {
		return "AccessoriesEntity{" +
				", id=" + id +
				"info='" + info + '\'' +
				", kind='" + kind + '\'' +
				", discount=" + discount +
				", amount=" + amount +
				", type='" + type + '\'' +
				", producing_country='" + producing_country + '\'' +
				", price=" + price +
				'}';
	}


}
