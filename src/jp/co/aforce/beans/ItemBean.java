package jp.co.aforce.beans;

public class ItemBean implements java.io.Serializable{

	private String item_id;
	private String item_name;
	private int item_price;
	private String item_photo;
	private String item_category;
	private String item_explain;

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

	public String getItem_category() {
		return item_category;
	}
	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public String getItem_explain() {
		return item_explain;
	}
	public void setItem_explain(String item_explain) {
		this.item_explain = item_explain;
	}

}
