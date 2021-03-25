package com.tyss.jpawithHibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithHibernate.dto.Person;

public class GetSingleRecord {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select p from Person p where p.id = 1";
		Query query = manager.createQuery(jpql);

		Person person = (Person) query.getSingleResult();

		System.out.println("\nPerson Id : " + person.getId());
		System.out.println("Person Name : " + person.getName());
		System.out.println("Person EMail : " + person.getEmail());
		
		manager.close();

	} // End of main

} // End of class
