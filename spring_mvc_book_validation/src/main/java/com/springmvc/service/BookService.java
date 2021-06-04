package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.BookDao;
import com.springmvc.model.Book;

@Service
public class BookService {
	@Autowired BookDao bDao;
	public List<Book> listAll() {
		return bDao.getAllBook();
	}

	public void removeBook(int id) {
		bDao.removeBook(id);
	}
	
	public void addBook(Book book) {
		bDao.addBook(book);
//		System.out.println("addbook");
	}
	
}
