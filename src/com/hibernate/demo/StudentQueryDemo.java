package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class StudentQueryDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session;

		try {

			session = factory.getCurrentSession();

			session.beginTransaction();

			var students = session.createQuery("from Student").getResultList();

			System.out.println("\nAll Students : ");
			System.out.println(students);

			students = session.createQuery("from Student s Where s.lastName='Ranjan'").getResultList();

			System.out.println("\nLastName : Ranjan1 or firstName : Prashant : ");
			System.out.println(students);

			students = session.createQuery("from Student s Where s.lastName='Ranjan1' OR s.firstName='Prashant'")
					.getResultList();

			System.out.println("\nLast Name : Ranjan : ");
			System.out.println(students);

			students = session.createQuery("from Student s Where s.email LIKE 'Ranjan%'").getResultList();

			System.out.println("\nemail LIKE Ranjan% :");
			System.out.println(students);

			session.getTransaction().commit();

			System.out.println("Done! ");

		} finally {
			factory.close();
		}
	}

}
