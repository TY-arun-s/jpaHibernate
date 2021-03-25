package com.tyss.jpawithHibernate.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertDemorollback {
	
	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;

		Person person = new Person();
		person.setId(1);
		person.setName("Rocky");
		person.setEmail("rocky@gmail.com");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(person);
			transaction.commit();
			System.out.println("Record Inserted");
		} catch (Exception e) {
			transaction.rollback(); // rollback if any exception
			e.printStackTrace();
		}

		manager.close();

	} // End of main

} // End of class
