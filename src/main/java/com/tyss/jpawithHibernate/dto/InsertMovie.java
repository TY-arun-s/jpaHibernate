package com.tyss.jpawithHibernate.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertMovie {

	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;

		Movie movie = new Movie();
		movie.setMid(1);
		movie.setMname("KGF1");
		movie.setRating("Rating 4");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(movie);
			transaction.commit();
			System.out.println("Record Inserted");
		} catch (Exception e) {
			transaction.rollback(); // rollback if any exception
			e.printStackTrace();
		}

		manager.close();

	} // End of main

}
// End of class
