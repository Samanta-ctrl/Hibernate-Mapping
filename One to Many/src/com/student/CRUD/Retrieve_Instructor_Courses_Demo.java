package com.student.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

import com.student.entity.Course;
import com.student.entity.Instructor;
import com.student.entity.InstructorDetail;

public class Retrieve_Instructor_Courses_Demo 
{
	public static void main(String[] args) 
	{
		//create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		//use the session object to save the java object in try block
		try
		{	
			//start the transaction
			System.out.println("Transaction begins...");
			session.beginTransaction(); 
			
			//get the instriction from the db
			int theId=1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("About Instructor: "+tempInstructor);
			
			System.out.println(); //new line
			
			//Get the course for instructor
			System.out.println("Courses are: "+tempInstructor.getCourses() );
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Committed Sucessully!");
			
		}
		
		//closing the costly resources to cleanup the code  in the finally block
		finally
		{
			session.close();
			factory.close();
		}
	}

}
