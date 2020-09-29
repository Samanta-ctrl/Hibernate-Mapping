package com.student.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

import com.student.entity.Course;
import com.student.entity.Instructor;
import com.student.entity.InstructorDetail;

public class Delete_Courses_Demo 
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
			
			//get a course
			int theId=10;
			Course tempCourse = session.get(Course.class, theId);
		
			
			//delete a course by id
			System.out.println("Deleting the course..."+tempCourse);
			session.delete(tempCourse); //course id =10 will be deleted and it will no longer in the database
			
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
