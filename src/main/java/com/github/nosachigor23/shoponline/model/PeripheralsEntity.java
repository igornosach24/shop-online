package com.github.nosachigor23.shoponline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "peripherals")
public class PeripheralsEntity extends AProductEntity implements Serializable {
	
	private static final long serialVersionUID = -6595503124147L;

	@Column(name = "kind")
	private String kind;

	@Column(name = "info")
	private String info;

	@Column(name = "discount")
	private int discount = calculateDiscountForProduct();

	{

		this.type = "peripherals";

	}

	public PeripheralsEntity() {
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

	/*

	The periphery has a default discount

	 */

	@Override
	public String toString() {
		return "Peripherals{" +
				"kind='" + kind + '\'' +
				", info='" + info + '\'' +
				", discount=" + discount +
				'}';
	}

	@Override
	protected int calculateDiscountForProduct() {

		if (!day.matches("WEDNESDAY|THURSDAY")) {
			return 0;
		}

		return DEFAULT_DISCOUNT_FOR_ALL_PRODUCTS;

	}

}
