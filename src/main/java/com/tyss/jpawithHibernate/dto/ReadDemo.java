package com.tyss.jpawithHibernate.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReadDemo {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		Person person = manager.find(Person.class, 222); /* manager.find(entityClass, classprimaryKey) */

		System.out.println("Person Id " + person.getId());
		System.out.println("Person Name " + person.getName());
		System.out.println("Person Email " + person.getEmail());

		manager.close();

	}

}
