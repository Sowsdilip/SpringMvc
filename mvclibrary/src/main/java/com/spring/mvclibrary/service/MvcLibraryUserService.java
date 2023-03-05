package com.spring.mvclibrary.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvclibrary.dao.MvcLibraryDao;
import com.spring.mvclibrary.model.User;

@Service
public class MvcLibraryUserService {

	private MvcLibraryDao dao;

	@Autowired
	public MvcLibraryUserService(MvcLibraryDao mvcLibraryDao) {
		this.dao = mvcLibraryDao;
	}

	public void addUser(User user) {
		dao.insertUserIntoDB(user);
	}

	public ArrayList<User> showUser() {
		// TODO Auto-generated method stub
		return dao.loadUsersFromDb();
	}

	public ArrayList<String> showUserBooks(String uname) {
		// TODO Auto-generated method stub
		return dao.loadUserBooksFromDb(uname);
	}

	public String checkOut(String bname, String uname) {
		String result = null;
		
		if (dao.updateBookQuanity("decrement",bname))
			if (dao.updateUserBooks("insert",uname,bname))
				result = bname + " issued to " + uname;
			else
				result = uname + "books limit exceeded";
		else
			result = bname + "not available";
    
		return result;

	}

	public void checkIn(String bname, String uname) {
	  boolean result;
	  result = dao.updateBookQuanity("increment",bname);
	  result = dao.updateUserBooks("delete",uname,bname);
	}

}
