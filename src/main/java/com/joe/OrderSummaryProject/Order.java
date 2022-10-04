package com.joe.OrderSummaryProject;

import java.util.Date;

public class Order {
	private String orderId;
	private String orderType;
	private Date date;
	private String paymentMethod;
	private String mealPeriod;
	private double commission;
	private double additionalCharges;
	private double subTotal;
	private double tax;
	private double total;
	private double totalEarned;

	public Order(String orderId, String orderType, Date date, String paymentMethod, String mealPeriod,
			double commission, double additionalCharges, double subTotal, double tax, double total,
			double totalEarned) {
		super();
		this.orderId = orderId;
		this.orderType = orderType;
		this.date = date;
		this.paymentMethod = paymentMethod;
		this.mealPeriod = mealPeriod;
		this.commission = commission;
		this.additionalCharges = additionalCharges;
		this.subTotal = subTotal;
		this.tax = tax;
		this.total = total;
		this.totalEarned = totalEarned;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getMealPeriod() {
		return mealPeriod;
	}

	public void setMealPeriod(String mealPeriod) {
		this.mealPeriod = mealPeriod;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public double getAdditionalCharges() {
		return additionalCharges;
	}

	public void setAdditionalCharges(double additionalCharges) {
		this.additionalCharges = additionalCharges;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotalEarned() {
		return totalEarned;
	}

	public void setTotalEarned(double totalEarned) {
		this.totalEarned = totalEarned;
	}

}
