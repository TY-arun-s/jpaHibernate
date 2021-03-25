package com.tyss.jpawithHibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithHibernate.oneToOne.Aadhar;
import com.tyss.jpawithHibernate.oneToOne.Person1;

public class TestOneToOne {

	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");

		Aadhar aadhar = new Aadhar();
		aadhar.setAid(12);
		aadhar.setAddress("abc");

		Person1 person1 = new Person1();
		person1.setPid(3);
		person1.setName("Suresh");
		person1.setAadhar(aadhar);

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			manager.persist(person1);

			transaction.commit();
			System.out.println("Record Inserted");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback(); // Roll Back if Transaction is failed
		}

		manager.close();

	} // End of main

} // End of class
