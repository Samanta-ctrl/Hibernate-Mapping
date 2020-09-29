package com.student.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

import com.student.entity.Course;
import com.student.entity.Instructor;
import com.student.entity.InstructorDetail;

public class Create_Instructor_Demo 
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
			
			//Create the objects of Instructor class and InstructorDetails class
			Instructor tempinstructor = new Instructor("Arindam","Patra","arindam95@gmail.com");
			
			
			//Create the objects of Instructor class and InstructorDetails class 
			System.out.println("Create the objects of Instructor class and InstructorDetails class");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.arindampatra/youtube","Cricket");
			
			//Associate the objects
			tempinstructor.setInstructorDetails(tempInstructorDetail); //now these two objects are associated in the memory
			
			//start the transaction
			System.out.println("Transaction begins...");
			session.beginTransaction(); 
			
			//save the instructor
			System.out.println("Saving instructor: "+tempinstructor);
			session.save(tempinstructor); //here it will also save the object and its associated objects because of CascadeType.ALL
			
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
