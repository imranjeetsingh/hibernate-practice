package com.ranjeet.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ranjeet.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("deleting student object ...");
			
			session.beginTransaction();
			
			int studentId = 2;
			
			Student student = session.get(Student.class, studentId);
			
			session.delete(student);
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where id='4'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!!");
		}
		finally {
			factory.close();
		}
	}
}
