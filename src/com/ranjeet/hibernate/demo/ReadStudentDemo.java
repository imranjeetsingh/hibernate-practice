package com.ranjeet.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ranjeet.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Reading stident object ...");
			
			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student").getResultList();
			
			DisplayStudent(students);
			
			students = session.createQuery("from Student s where s.id='1'")
					 .getResultList();
			
			DisplayStudent(students);
			
			students = session.createQuery("from Student s where "
					+ "s.id='1' OR s.id='4'").getResultList();
			
			DisplayStudent(students);
			
			students = session.createQuery("from Student s where "
					+ "s.firstName LIKE '%ranjeet1'").getResultList();
			
			DisplayStudent(students);
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!!!!!!");
		}
		finally {
			factory.close();
		}
	}

	private static void DisplayStudent(List<Student> students) {
		for(Student data:students) {
			System.out.println(data);
		}
	}

}
