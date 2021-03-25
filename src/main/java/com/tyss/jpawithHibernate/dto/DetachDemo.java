package com.tyss.jpawithHibernate.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DetachDemo {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Person person = manager.find(Person.class, 1);
			System.out.println("Before detach() " + manager.contains(person)); // true
			manager.detach(person); // detach
			System.out.println("After detach() " + manager.contains(person)); // false
			person.setName("Rahul");
			Person mergeRecord = manager.merge(person); // merge
			mergeRecord.setName("Rocky");
			transaction.commit();
			System.out.println("Record Inserted");
		} catch (Exception e) {
			transaction.rollback(); // rollback if any exception
			e.printStackTrace();
		}

		manager.close();

	} // End of main

} // End of class
