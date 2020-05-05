package com.products.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="Product_Id")
	private int prodId;
	@Column(name ="Product_Name")
	private String prodName;
	@Column(name="Product_Price")
	private String prodPrice;
	@Column(name="Product_Description")
	private String prodDesc;
	@Column(name="Product_Rating")
	private String prodRating;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public String getProdRating() {
		return prodRating;
	}
	public void setProdRating(String prodRating) {
		this.prodRating = prodRating;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", prodId=" + prodId + ", prodName=" + prodName + ", prodPrice=" + prodPrice
				+ ", prodDesc=" + prodDesc + ", prodRating=" + prodRating + "]";
	}
	
}
