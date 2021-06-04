package com.springmvc.dbConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DbConnection {
	protected String pUnitName = "spring_mvc_book_validation";
	protected EntityManagerFactory emf = null;
	protected EntityManager em = null;
	
	public void connect() {
		this.emf = Persistence.createEntityManagerFactory(pUnitName);
		this.em = emf.createEntityManager();
	}
	
	public void disconnect() {
		if (this.em!=null) {
			em.close();
		}
		if (this.emf!=null) {
			emf.close();
		}
	}
}
