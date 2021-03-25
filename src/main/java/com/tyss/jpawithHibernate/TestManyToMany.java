package com.tyss.jpawithHibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithHibernate.ManyToMany.Courses;
import com.tyss.jpawithHibernate.ManyToMany.Students;

public class TestManyToMany {

	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");

//		List<Students> Students = new ArrayList<Students>();

		List<Courses> courses1 = new ArrayList<Courses>();
		List<Courses> courses2 = new ArrayList<Courses>();

		Courses cours1 = new Courses();
		cours1.setCid(111);
		cours1.setCname("SQL");

		Courses cours2 = new Courses();
		cours2.setCid(112);
		cours2.setCname("Java");

		Courses cours3 = new Courses();
		cours3.setCid(113);
		cours3.setCname("J2EE");

		courses1.add(cours1);
		courses1.add(cours2);

		courses2.add(cours2);
		courses2.add(cours3);

		Students st1 = new Students();
		st1.setSid(2);
		st1.setSname("Suresh");
		st1.setCourses(courses1);

		Students st2 = new Students();
		st2.setSid(3);
		st2.setSname("Sainesh");
		st2.setCourses(courses2);

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			manager.persist(st1);
			manager.persist(st2);

			transaction.commit();
			System.out.println("Record Inserted");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback(); // Roll Back if Transaction is failed
		}

		manager.close();

	} // End of main

} // End of class
