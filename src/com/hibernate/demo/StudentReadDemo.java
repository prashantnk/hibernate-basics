package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class StudentReadDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session;

		try {

			session = factory.getCurrentSession();

			Student toSave = new Student("Prashant", "Ranjan", "prashantnk2001@gmail.com");

			session.beginTransaction();

			session.save(toSave);
			session.getTransaction().commit();

			System.out.println("Done saving  : " + toSave);

			session = factory.getCurrentSession();

			session.beginTransaction();
			Student readStudent = session.get(Student.class, toSave.getId());

			session.getTransaction().commit();

			System.out.println("Retrieved Student : " + readStudent);

		} finally {
			factory.close();
		}
	}

}
