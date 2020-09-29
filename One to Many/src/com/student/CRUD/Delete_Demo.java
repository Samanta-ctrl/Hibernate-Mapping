package com.student.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.student.entity.Instructor;
import com.student.entity.InstructorDetail;

public class Delete_Demo 
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
			
			//get instructor by primary key / id
			int theId = 1;
			Instructor inst = session.get(Instructor.class,theId); // returns null if the id is not found
			System.out.println("Found instructor: "+inst);
			
			//delete the instructors
			if(inst != null)
			{
				System.out.println("Deleteing the instructor: "+inst);
				//NOTE:- it will also delete the associated 'details' object because of CascadeType.ALL 
				session.delete(inst);
			}
			//commit the new transaction
			session.getTransaction().commit();
			System.out.println("\nCommitted Sucessully!");
			
			
		}
		
		//closing the costly resources in the finally block
		finally
		{
			factory.close();
		}
	}

}
