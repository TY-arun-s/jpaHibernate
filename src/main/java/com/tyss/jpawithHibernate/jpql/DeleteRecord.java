package com.tyss.jpawithHibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteRecord {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql = "delete from Person p where id = 111";
		Query query = manager.createQuery(jpql);
		int result = query.executeUpdate();
		transaction.commit();

		if (result != 0)
			System.out.println("Record Deleted " + result);
		else
			System.out.println("Unable to Delete " + result);

		manager.close();

	} // End of main

} // End of class
