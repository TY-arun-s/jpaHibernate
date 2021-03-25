package com.tyss.jpawithHibernate.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertDemo {

	public static void main(String[] args) {

		Person person = new Person();
		person.setId(222);
		person.setName("Shiva");
		person.setEmail("shiva@gmail.com");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(person);
		transaction.commit();
		System.out.println("Record Inserted");
		manager.close();

	} // End of main

} // End of class
