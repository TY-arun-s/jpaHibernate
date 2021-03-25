package com.tyss.jpawithHibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithHibernate.dto.Person;

public class DynamicGetRecord {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select p from Person p where p.id =: pid";
		Query query = manager.createQuery(jpql);
		query.setParameter("pid", 1);
		Person person = (Person) query.getSingleResult();

		System.out.println("\nPerson Id : " + person.getId());
		System.out.println("Person Name : " + person.getName());
		System.out.println("Person EMail : " + person.getEmail());

		manager.close();

	} // End of main

} // End of class
