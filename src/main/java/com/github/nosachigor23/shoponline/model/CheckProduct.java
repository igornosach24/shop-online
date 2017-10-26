package com.github.nosachigor23.shoponline.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "sold_products")
public class CheckProduct extends ABaseDaoEntity implements Serializable {

	private static final long serialVersionUID = -6955030646638117L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "date")
	private LocalDateTime dateSale;
	@Column(name = "information")
	private String info;
	@Column(name = "amount")
	private int amount;
	@Column(name = "price")
	private int price;
	@Column(name = "discount")
	private int discount;
	@Column(name = "price_for_sale")
	private int priceForSale = (getPrice() * getDiscount()) + getPrice();
	@Column(name = "id_product")
	private int id_product;

	public CheckProduct() {
	}

	public int getPriceForSale() {
		return priceForSale;
	}

	public void setPriceForSale(int priceForSale) {
		this.priceForSale = priceForSale;
	}

	public LocalDateTime getDateSale() {
		return dateSale;
	}

	public void setDateSale(LocalDateTime dateSale) {
		this.dateSale = dateSale;
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

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Check{" +
				"dateSale=" + dateSale +
				", info='" + info + '\'' +
				", amount=" + amount +
				", price=" + price +
				", discount=" + discount +
				", priceForSale=" + priceForSale +
				", id_product=" + id_product +
				'}';
	}
}
