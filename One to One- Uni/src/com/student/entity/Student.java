package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Step-1: Map the class to the database table

@Entity
@Table(name="student")
public class Student 
{
	//Step-2: Map these private fields to the database columns
	
	@Id // making Id as primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //for Explicit auto generated value (MySQL will handle this)
	@Column(name="id") //specify the actual column name and then specify the field called id to map the database
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	//define no-args constructor
	public Student()
	{
		System.out.println("No-args constructor");
	}

	//generating a parameterized constructor
	public Student(String firstName, String lastName, String email) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	//generating getter and setter method
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//generate toString() method for debugging purposes
	@Override
	public String toString() 
	{
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}


/*
 Q. Why we are using JPA Annotation instead of Hibernate ? For example, why we are not using this org.hibernate.annotations.Entity?
 -->
 		JPA is a standard specification. Hibernate is an implementation of the JPA specification.
	Hibernate implements all of the JPA annotations.
		
	The Hibernate team recommends the use of JPA annotations as a best practice.
 */




