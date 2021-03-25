package com.tyss.jpawithHibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithHibernate.dto.Person;

public class GetAll {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select p from Person p";
		Query query = manager.createQuery(jpql);
		List<Person> personList = query.getResultList();
		for (Person person : personList) {
			System.out.println("\nPerson Id : " + person.getId());
			System.out.println("Person Name : " + person.getName());
			System.out.println("Person EMail : " + person.getEmail());
		} // End of forEach loop

		manager.close();

	} // End of main

} // End of class
