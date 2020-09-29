package com.student.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

import com.student.entity.Course;
import com.student.entity.Instructor;
import com.student.entity.InstructorDetail;
import com.student.entity.Student;

public class Create_Courses_and_Students_Demo 
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
			
			//create a course
			Course tempCourse = new Course("Pacman - How to score One Million Points");
		
			//save the course
			System.out.println("Saving the courses..");
			session.save(tempCourse);
			System.out.println("Saved the courses: "+tempCourse);
			
			//create the students
			Student tempStdent1 = new Student("Soumen","Samanta","soumen95@gmail.com");
			Student tempStdent2 = new Student("Jyoti","Kumari","jyoti96@gmail.com");
			
			
			//add the students
			tempCourse.addStudent(tempStdent1);
			tempCourse.addStudent(tempStdent2);
			
			//save the students
			System.out.println("Saving the students...");
			session.save(tempStdent1);
			session.save(tempStdent2);
			System.out.println("Studets saved completes.."+tempCourse.getStudents());
			
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
