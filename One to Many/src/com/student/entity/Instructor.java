package com.student.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//1. Annotate the class as an entity and map to the database entity

@Entity
@Table(name="instructor")
public class Instructor
{
	// 2. define the fields and annotate the fields with db column names

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	//** set up the mapping between Instructor and InstructorDetail
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id") //join and map our column in the instructor class and map over primary key in the instructor_details
	private InstructorDetail instructorDetail;

	
	
	// 3. create no-args constructor
	public Instructor() 
	{
	
	}

	// 4. parameterized constructor
	public Instructor(String firstName, String lastName, String email) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	// 5. generate getter/setter methods
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

	public InstructorDetail getInstructorDetails() {
		return instructorDetail;
	}

	public void setInstructorDetails(InstructorDetail instructorDetails) 
	{
		this.instructorDetail = instructorDetails;
	}

	// 6. generate toString() method
	@Override
	public String toString() 
	{
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetails=" + instructorDetail + "]";
	}
	
	//add a new field and annotate it
		@OneToMany(mappedBy = "instructor",   //refers to instructor property in Course class
				cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} )
		private List<Course> courses;
		
		
		//generate getter/setter method for new fields
		public List<Course> getCourses() {
			return courses;
		}

		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}

		//add convenience method for bi-directional mapping / relationship
		public void add(Course tempCourse)
		{
			if(courses == null)
			{
				courses = new ArrayList<>();
			}
			courses.add(tempCourse);
			tempCourse.setInstructor(this); //bi-directional mapping b/w course and actual instructor
		}
}
