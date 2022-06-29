package jp.co.aforce.beans;

import java.io.Serializable;

public class CartBean implements Serializable {

	private int cart_item_num;
	private String item_id;
	private String item_name;
	private int item_price;
	private String item_photo;
	private int item_count;
	private int total_price;

	public int getCart_item_num() {
		return cart_item_num;
	}
	public void setCart_item_num(int cart_item_num) {
		this.cart_item_num = cart_item_num;
	}

	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public String getItem_photo() {
		return item_photo;
	}
	public void setItem_photo(String item_photo) {
		this.item_photo = item_photo;
	}

	public int getItem_count() {
		return item_count;
	}
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}

	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

}
