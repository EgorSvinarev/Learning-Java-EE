package main;

import entity.Book;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setTitle("Hello, world!");
		book.setPrice(10);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("book");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(book);
		tx.commit();
		
		em.close();
		emf.close();
	}

}
