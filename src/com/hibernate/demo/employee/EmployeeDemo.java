package com.hibernate.demo.employee;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Scanner sc = new Scanner(System.in);

		try {

			Session session = factory.getCurrentSession();

			Employee e = new Employee();

			session.beginTransaction();

			System.out.println("Enter Name : ");
			e.setName(sc.nextLine());
			System.out.println("Enter Company : ");
			e.setCompany(sc.nextLine());

			session.save(e);

			session.getTransaction().commit();

			System.out.println(e);

		} finally {
			factory.close();
			sc.close();
		}
	}

}
