package com.tyss.jpawithHibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithHibernate.oneToMany.PencilBox;
import com.tyss.jpawithHibernate.oneToMany.Pencils;

public class TestManyToOne {

	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");

		PencilBox box = new PencilBox();
		box.setBid(12);
		box.setBname("Nataraj");

		Pencils pencil = new Pencils();
		pencil.setPid(3);
		pencil.setPcolor("Black");
//		Pencil.setBox(box);

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

//			manager.persist(pencil);
//			PencilBox box = manager.find(PencilBox.class, 11);
			pencil.setBox(box);
			manager.persist(pencil);

			transaction.commit();
			System.out.println("Record Inserted");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback(); // Roll Back if Transaction is failed
		}

		manager.close();

	} // End of main

} // End of class
