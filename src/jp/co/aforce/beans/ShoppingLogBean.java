package jp.co.aforce.beans;

public class ShoppingLogBean {

	private String member_id;
	private String purchase_datetime;
	private int total_price;
	private String payment_method;
	private String logistic;

	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPurchase_datetime() {
		return purchase_datetime;
	}
	public void setPurchase_datetime(String purchase_datetime) {
		this.purchase_datetime = purchase_datetime;
	}

	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public String getLogistic() {
		return logistic;
	}
	public void setLogistic(String logistic) {
		this.logistic = logistic;
	}

}
