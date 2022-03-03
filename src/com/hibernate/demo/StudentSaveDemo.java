package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class StudentSaveDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Student toSave = new Student("Prashant", "Ranjan", "prashantnk2001@gmail.com");

			session.beginTransaction();

			session.save(toSave);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
