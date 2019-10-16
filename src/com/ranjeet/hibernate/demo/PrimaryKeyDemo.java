package com.ranjeet.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ranjeet.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating 3 new stident object ...");
			
			Student tempStudemt =  new Student("Ranjeet1","Singh","ranjee9170@gmail.com");
			Student tempStudemt1 =  new Student("Ranjeet11","Singh","ranjee91170@gmail.com");
			Student tempStudemt11 =  new Student("Ranjeet111","Singh","ranjee911170@gmail.com");
			
			session.beginTransaction();
			
			session.save(tempStudemt);
			session.save(tempStudemt1);
			session.save(tempStudemt11);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!!");
		}
		finally {
			factory.close();
		}
	}
		
}
