package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class StudentDeleteDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session;

		try {

			session = factory.getCurrentSession();

			session.beginTransaction();

			var s = session.get(Student.class, 1);

			session.delete(s);

			session.createQuery("delete Student where id=2").executeUpdate();

			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
