package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Book;

public interface BookDaoI {
	public boolean addBook(Book book);
	public Book getBook(int id);
	public Book updateBook(Book book);
	public Book removeBook(int id);
	public List<Book> getAllBook();
}
