package com.tyss.jpawithHibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithHibernate.oneToMany.PencilBox;
import com.tyss.jpawithHibernate.oneToMany.Pencils;

public class TestOneToMany {

	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");

		PencilBox box = new PencilBox();
		box.setBid(13);
		box.setBname("Nataraj");

		Pencils pencil1 = new Pencils();
		pencil1.setPid(4);
		pencil1.setPcolor("Black");

		Pencils pencil2 = new Pencils();
		pencil2.setPid(5);
		pencil2.setPcolor("Black");

		Pencils pencil3 = new Pencils();
		pencil3.setPid(6);
		pencil3.setPcolor("Black");

		List<Pencils> pencils = new ArrayList<Pencils>();

		box.setPencils(pencils);

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

//			manager.persist(pencil);
//			PencilBox box = manager.find(PencilBox.class, 11);
			
			manager.persist(box);

			transaction.commit();
			System.out.println("Record Inserted");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback(); // Roll Back if Transaction is failed
		}

		manager.close();

	} // End of main

} // End of class
