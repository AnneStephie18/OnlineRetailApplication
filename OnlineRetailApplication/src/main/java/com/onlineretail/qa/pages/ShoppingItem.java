package com.onlineretail.qa.pages;

public class ShoppingItem {

	private String ItemColor;
	private String ItemSize;
	private int ItemQuantity;
	
	public String getItemColor() {
		return ItemColor;
	}
	public void setItemColor(String itemColor) {
		ItemColor = itemColor;
	}
	public String getItemSize() {
		return ItemSize;
	}
	public void setItemSize(String itemSize) {
		ItemSize = itemSize;
	}
	public int getItemQuantity() {
		return ItemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		ItemQuantity = itemQuantity;
	}
	
	public ShoppingItem(String itemColor, String itemSize, int itemQuantity) {
		super();
		ItemColor = itemColor;
		ItemSize = itemSize;
		ItemQuantity = itemQuantity;
	}
}
