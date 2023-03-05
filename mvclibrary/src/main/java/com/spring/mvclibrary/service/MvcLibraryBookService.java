package com.spring.mvclibrary.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvclibrary.dao.MvcLibraryDao;
import com.spring.mvclibrary.model.Book;
import com.spring.mvclibrary.model.Entity;

@Service
public class MvcLibraryBookService{

	private MvcLibraryDao dao;
	
	@Autowired
	public MvcLibraryBookService(MvcLibraryDao mvcLibraryDao) {
		this.dao=mvcLibraryDao;
	}
	
	public ArrayList<Book> showBooks() {
		return dao.loadBooksFromDb();
	}

	public void addBook(Book book) {
		dao.insertBookToDb(book);
		
	}

	
}
