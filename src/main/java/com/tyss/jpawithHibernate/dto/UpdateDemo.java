package com.tyss.jpawithHibernate.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateDemo {

	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Person person = manager.find(Person.class, 222);
			person.setName("mahi@gmail.com");
			transaction.commit();
			System.out.println("Record Updated");
		} catch (Exception e) {
			transaction.rollback(); // Roll Back if any exception
			e.printStackTrace();
		}

		manager.close();

	} // End of main

} // End of class