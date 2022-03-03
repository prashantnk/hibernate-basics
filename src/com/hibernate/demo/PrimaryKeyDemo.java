package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Student toSave1 = new Student("Prashant1", "Ranjan", "prashantnk2001@gmail.com");
			Student toSave2 = new Student("Prashant2", "Ranjan", "prashantnk2001@gmail.com");
			Student toSave3 = new Student("Prashant3", "Ranjan", "prashantnk2001@gmail.com");

			session.beginTransaction();

			session.save(toSave1);
			session.save(toSave2);
			session.save(toSave3);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
