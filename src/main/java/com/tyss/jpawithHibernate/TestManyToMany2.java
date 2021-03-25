package com.tyss.jpawithHibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithHibernate.ManyToMany.Courses;
import com.tyss.jpawithHibernate.ManyToMany.Students;

public class TestManyToMany2 {

	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");

		List<Courses> courses1 = new ArrayList<Courses>();

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			Courses java = manager.find(Courses.class, 112);
			Courses j2ee = manager.find(Courses.class, 113);
			Courses hibernate = manager.find(Courses.class, 114);

			courses1.add(java);
			courses1.add(j2ee);
			courses1.add(hibernate);

			Students st1 = new Students();
			st1.setSid(5);
			st1.setSname("Mahesh");
			st1.setCourses(courses1);
			

			manager.persist(st1);

			transaction.commit();
			System.out.println("Record Inserted");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback(); // Roll Back if Transaction is failed
		}

		manager.close();

	} // End of main

} // End of class
