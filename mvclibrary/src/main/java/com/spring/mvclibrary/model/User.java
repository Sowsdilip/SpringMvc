package com.spring.mvclibrary.model;

import java.util.ArrayList;

public class User implements Entity {

	private String name;
	private ArrayList<String> books = new ArrayList<>();
	
	public User() {
		super();
	}

	public User(String uname) {
		super();
		this.name = uname;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	
	public ArrayList<String> getUserBooks() {
		// TODO Auto-generated method stub
		return books;
	}
	
	public void setUserBooks(ArrayList<String> names) {
		// TODO Auto-generated method stub
		this.books = names;
	}
	
}