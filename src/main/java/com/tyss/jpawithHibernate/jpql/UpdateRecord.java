package com.tyss.jpawithHibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class UpdateRecord {

	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "update Person p set name ='Mahi' where id = 1"; // static query
			Query query = manager.createQuery(jpql);
			int result = query.executeUpdate();
			transaction.commit();

			if (result != 0)
				System.out.println("Record Updated " + result);
			else
				System.out.println("Unable to Update " + result);

		} catch (Exception e) {
			transaction.rollback(); // rollback if any exception
			e.printStackTrace();
		}

		manager.close();

	} // End of main

} // End of class
