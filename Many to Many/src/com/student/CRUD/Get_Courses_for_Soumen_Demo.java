package com.student.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

import com.student.entity.Course;
import com.student.entity.Instructor;
import com.student.entity.InstructorDetail;
import com.student.entity.Student;

public class Get_Courses_for_Soumen_Demo 
{
	public static void main(String[] args) 
	{
		//create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		//use the session object to save the java object in try block
		try
		{	
			//start the transaction
			System.out.println("Transaction begins...");
			session.beginTransaction(); 
			
			//get the student soumen from the dtabase
			int theId = 1; //soumen id
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("\nLoading students.."+tempStudent);
			System.out.println("Courses: "+tempStudent.getCourses() );
		
			
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
