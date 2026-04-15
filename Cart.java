
	package com.app.model;

	import java.util.HashMap;
	import java.util.Map;

	public class Cart {

	    private Map<Integer, CartItem> items = new HashMap<>();

	    // Add item to cart
	    public void addItem(CartItem item) {

	       
	            int id = item.getCartItemId();

	            CartItem existing = items.get(id);

	            if (existing != null) {
	                existing.setCartQuantity(existing.getCartQuantity() + item.getCartQuantity());
	            } else {
	                items.put(id, item);
	            }
	        }
	    

	    // Remove item
	    public void removeItem(int id) {
	        items.remove(id);
	    }

	    // Update quantity
	    
	    public void updateItem(int id, int quantity) {
	        if (items.containsKey(id)) {
	            if (quantity <= 0) {
	                items.remove(id);
	            } else {
	                items.get(id).setCartQuantity(quantity);
	            }
	        }
	    }

	    // Get all items
	    public Map<Integer, CartItem> getItems() {
	        return items;
	    }

	    // Total price
	    public double getTotalPrice() {
	        double total = 0;

	        for (CartItem item : items.values()) {
	            total += item.getCartPrice() * item.getCartQuantity();
	        }

	        return total;
	    }
	    

    	public int getTotalItems() 
    	{
    	    int count = 0;

    	    for (CartItem item : items.values()) {
    	        count += item.getCartQuantity();
    	    }

    	    return count;
    	}

    	public double getSubtotal() 
    	{
    	    double total = 0;

    	    for (CartItem item : items.values()) {
    	        total += item.getTotalPrice();
    	    }

    	    return total;
    	}

    	public double getGST() {
    	    return getSubtotal() * 0.05; // 5% GST
    	}

    	public double getDeliveryCharge() {
    	    return getSubtotal() > 500 ? 0 : 40;
    	}

    	public double getGrandTotal() {
    	    return getSubtotal() + getGST() + getDeliveryCharge();
    	}
    }
		
