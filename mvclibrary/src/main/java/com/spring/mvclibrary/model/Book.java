package com.spring.mvclibrary.model;



public class Book implements Entity{

	private String name;
	private long Quantity;
	
	public Book() {
		super();		
	}

	public Book(String bookName, long quantity) {
		super();
		this.name = bookName;
		Quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String bookName) {
		this.name = bookName;
	}

	public long getQuantity() {
		return Quantity;
	}

	public void setQuantity(long quantity) {
		Quantity = quantity;
	}

	public String toString() {
		return "Book [bookName=" + name + ", Quantity=" + Quantity + "]";
	}

}

