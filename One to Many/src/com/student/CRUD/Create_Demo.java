package com.student.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

import com.student.entity.Instructor;
import com.student.entity.InstructorDetail;

public class Create_Demo 
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
			/*
			 * //Create the objects of Instructor class and InstructorDetails class
			 * System.out.
			 * println("Create the objects of Instructor class and InstructorDetails class"
			 * ); Instructor inst = new
			 * Instructor("Soumen","Samanta","soumensamanta95@yahoo.com"); InstructorDetail
			 * instdtl = new InstructorDetail("http://www.soumen/youtube","Love to code");
			 */
			
			//Create the objects of Instructor class and InstructorDetails class 
			System.out.println("Create the objects of Instructor class and InstructorDetails class");
			Instructor inst = new Instructor("Jyoti","Kumari","jyoti@yahoo.com");
			InstructorDetail instdtl = new InstructorDetail("http://www.jyotikumari/youtube","Music");
			
			//Associate the objects
			inst.setInstructorDetails(instdtl); //now these two objects are associated in the memory
			
			//start the transaction
			System.out.println("Transaction begins...");
			session.beginTransaction(); 
			
			//save the instructor
			System.out.println("Saving instructor: "+inst);
			session.save(inst); //here it will also save the object and its associated objects because of CascadeType.ALL
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Committed Sucessully!");
			
		}
		
		//closing the costly resources in the finally block
		finally
		{
			factory.close();
		}
	}

}
