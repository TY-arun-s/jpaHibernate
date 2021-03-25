package com.tyss.jpawithHibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithHibernate.oneToOne.Aadhar;

public class TestOneToOne2 {

	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			Aadhar aadhar = manager.find(Aadhar.class, 11);
			System.out.println("Person Id : " + aadhar.getPerson().getPid());
			System.out.println("Person Name : " + aadhar.getPerson().getName());
			System.out.println("Aadhar Id : " + aadhar.getAid());
			System.out.println("Aadhar Address : " + aadhar.getAddress());

			System.out.println(aadhar.toString());

			transaction.commit();
			System.out.println("Record Inserted");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback(); // Roll Back if Transaction is failed
		}

		manager.close();

	} // End of main

} // End of class
