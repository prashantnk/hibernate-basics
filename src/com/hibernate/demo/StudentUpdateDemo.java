package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class StudentUpdateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session;

		try {

			session = factory.getCurrentSession();

			session.beginTransaction();

			Student s = (Student) session.createQuery("from Student where id=1").getResultList().get(0);

			System.out.println(s);

			s.setFirstName("armin");

			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();

			s = (Student) session.createQuery("from Student where id=1").getResultList().get(0);

			System.out.println(s);
			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();
//
			session.createQuery("update Student set email='dummy@d.com'").executeUpdate();
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
