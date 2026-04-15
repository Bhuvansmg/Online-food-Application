package com.app.model;

public class CartItem 
{
	
	private int cartItemId;
	private String cartName;
	private double cartPrice;
	private int cartQuantity;
	
	private String cartImage;
	
	
	
	
	public CartItem() {
		super();
	}






	public CartItem(int cartItemId, String cartName, double cartPrice, int cartQuantity ,String cartImage) {
		super();
		this.cartItemId = cartItemId;
		this.cartName = cartName;
		this.cartPrice = cartPrice;
		this.cartQuantity = cartQuantity;
		this.cartImage=cartImage;
	}






	public int getCartItemId() {
		return cartItemId;
	}






	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}






	public String getCartName() {
		return cartName;
	}






	public void setCartName(String cartName) {
		this.cartName = cartName;
	}






	public double getCartPrice() {
		return cartPrice;
	}






	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}






	public int getCartQuantity() {
		return cartQuantity;
	}






	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	
	  public double getTotalPrice() {
	        return cartPrice * cartQuantity;
	    }






	  public String getCartImage() {
		  return cartImage;
	  }






	  public void setCartImage(String cartImage) {
		  this.cartImage = cartImage;
	  }






}
