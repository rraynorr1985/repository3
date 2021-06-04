package com.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dbConnection.DbConnection;
import com.springmvc.model.Book;

@Repository
public class BookDao extends DbConnection implements BookDaoI {
	@Override
	public boolean addBook(Book book){
		try {
			this.connect();
			em.getTransaction().begin();
			em.persist(book);
			em.getTransaction().commit();
			this.disconnect();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Book getBook(int id) {
		this.connect();
		Book bookFound = em.find(Book.class, id);
		this.disconnect();
		return bookFound;
	}
	@Override
	public Book updateBook(Book book) {
		try {
			this.connect();
			em.getTransaction().begin();
			Book bookFound = em.find(Book.class, book.getBookId());
			bookFound.setTitle(book.getTitle());
			bookFound.setAuthor(book.getAuthor());
			em.getTransaction().commit();
			this.disconnect();
			return bookFound;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Book removeBook(int id) {
		try {
			this.connect();
			em.getTransaction().begin();
			Book bookFound = em.find(Book.class, id);
			em.remove(bookFound);
			em.getTransaction().commit();
			this.disconnect();
			return bookFound;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Book> getAllBook() {
		this.connect();
		@SuppressWarnings("unchecked")
		List<Book> books = em.createQuery("select b from Book b").getResultList();	
		this.disconnect();
		return books;
	}
}
