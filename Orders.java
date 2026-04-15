package com.app.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Orders 
{
	private int orderId;
	private int userId;
	private int restaurantId;
	private Timestamp date; 
	private String paymentMode;
	private String address;
	private String status;
	private double totalAmount;

	
	private List<OrderItems> orderItems;
	
	
	public Orders() 
	{	super();
		this.date=new Timestamp(System.currentTimeMillis());
		orderItems=new ArrayList<>();
	}




	public Orders(int orderId, int userId, int restaurantId, Timestamp date, String paymentMode, String address,
			String status, double totalAmount) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.date = date;
		this.paymentMode = paymentMode;
		this.address = address;
		this.status = status;
		this.totalAmount = totalAmount;
	
	}




	public Orders(int userId, int restaurantId, Timestamp date, String paymentMode, String address,
			String status, double totalAmount) {
		super();
		
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.date = date;
		this.paymentMode = paymentMode;
		this.address = address;
		this.status = status;
		this.totalAmount = totalAmount;
	}




	public int getOrderId() {
		return orderId;
	}




	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}




	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public int getRestaurantId() {
		return restaurantId;
	}




	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}




	public Timestamp getDate() {
		return date;
	}




	public void setDate(Timestamp date) {
		this.date = date;
	}




	public String getPaymentMode() {
		return paymentMode;
	}




	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}







	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public double getTotalAmount() {
		return totalAmount;
	}




	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}




	public List<OrderItems> getOrderItem() {
		return orderItems;
	}




	public void setOrderItem(List<OrderItems> orderItem) {
		orderItems = orderItem;
	}
	
	
	public void addOrderItem(OrderItems item)
	{
		this.orderItems.add(item);
		this.totalAmount += item.getTotalPrice();
	}




	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", date=" + date
				+ ", paymentMode=" + paymentMode + ", address=" + address + ", status=" + status + ", totalAmount="
				+ totalAmount + ", orderItems=" + orderItems + "]";
	}
	
	
	
}
