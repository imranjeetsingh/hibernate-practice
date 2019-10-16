package com.ranjeet.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ranjeet.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Update stident object ...");
			
			session.beginTransaction();
			
			int studentId = 4;
			
			Student student = session.get(Student.class, studentId);
			
			student.setFirstName("IronMan");
			
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!!!!!!");
		}
		finally {
			factory.close();
		}
	}
}
