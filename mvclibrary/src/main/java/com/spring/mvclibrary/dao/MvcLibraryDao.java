package com.spring.mvclibrary.dao;

import java.util.ArrayList;

import com.spring.mvclibrary.model.Book;
import com.spring.mvclibrary.model.Entity;
import com.spring.mvclibrary.model.User;

public interface MvcLibraryDao {

	ArrayList<Book> loadBooksFromDb();

	void insertBookToDb(Book book);

	void insertUserIntoDB(User user);

	ArrayList<User> loadUsersFromDb();

	ArrayList<String> loadUserBooksFromDb(String uname);

	boolean updateBookQuanity(String string, String bname);

	boolean updateUserBooks(String string, String uname, String bname);

	

}
