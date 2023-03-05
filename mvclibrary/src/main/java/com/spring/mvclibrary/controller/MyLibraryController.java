package com.spring.mvclibrary.controller;


import java.util.ArrayList;
import com.spring.mvclibrary.model.Book;
import com.spring.mvclibrary.model.User;
import com.spring.mvclibrary.service.MvcLibraryBookService;
import com.spring.mvclibrary.service.MvcLibraryUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
public class MyLibraryController {
	

	@Autowired
	private MvcLibraryBookService bookservice;
	@Autowired
	private MvcLibraryUserService userservice;
	
	@RequestMapping(method = RequestMethod.GET, value ="/")
	public String welcomePage() {
		return "welcome";
	}

	@RequestMapping(method = RequestMethod.GET, value ="home")
	public String homePage() {
		return "welcome";
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="showbooks")
	public String showBooks(ModelMap bookmodel) {
	bookmodel.addAttribute("books",bookservice.showBooks());
	return "displaybooks";
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="add-book")
	public String addBook(){
		return "addbook";
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="addbooks")
	public String addBook(Book book){
	
		bookservice.addBook(book);
		return "welcome";
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="add-user")
	public String addUser(){
		return "adduser";
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="addusers")
	public String addUser(User user) {
			userservice.addUser(user);
			return "welcome";
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value ="showusers")
		public String showUsers(ModelMap usermodel) {
	 	usermodel.addAttribute("users",userservice.showUser());
		return "displayusers";
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value ="display-user-books")
		public String showUserBoooks(){
			return "displayuserbooks";
		}
	 
	 @RequestMapping(method = RequestMethod.GET, value ="display-user-books-result")
	 public String showUserBooks(@RequestParam String uname,ModelMap usermodel1) {
		usermodel1.addAttribute("userbooks", userservice.showUserBooks(uname));
	    return "displayuserbooksresult";
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value ="checkout")
	 public String checkOut() {
		 return "checkoutbook";
	 }	
	 
	 @RequestMapping(method = RequestMethod.GET, value ="check-out-book")
	 public String checkOutBook(@RequestParam String uname,@RequestParam String bname) {
		
		 String result = userservice.checkOut(bname,uname);
		  return "welcome";
	 }	
	 
	 @RequestMapping(method = RequestMethod.GET, value ="checkin")
	 public String checkIn() {
		 return "checkinbook";
	 }	
	 
	 @RequestMapping(method = RequestMethod.GET, value ="check-in-book")
	 public String checkInBook(@RequestParam String uname,@RequestParam String bname) {
		 userservice.checkIn(bname,uname);
		 return "welcome";
	 }	
}
	 
