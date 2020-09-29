package com.student.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.student.entity.Instructor;
import com.student.entity.InstructorDetail;

public class GetInstructorDetailDemo 
{
	public static void main(String[] args) 
	{
		//create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		//use the session object to save the java object in try block
		try
		{			
			//now get a new session  and start a new transaction
			session.beginTransaction();
			
			//get the instructor details object 
			int theId=5; //returns null if the given id is not found and give an exception called NullPointerException
			
			InstructorDetail tempinstructorDetail = session.get(InstructorDetail.class,theId);
			
			//print the instructor details
			System.out.println("tempinstructorDetail: "+tempinstructorDetail);
			
			//print the associated instructor 
			System.out.println("The Associated instructor: "+tempinstructorDetail.getInstructor());
			
			//commit the new transaction
			session.getTransaction().commit();
			System.out.println("\nCommitted Sucessully!");
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		//closing the costly resources in the finally block
		finally
		{
			session.close();
			
			factory.close();
		}
	}

}
