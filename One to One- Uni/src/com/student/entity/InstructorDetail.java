package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// 1. Annotate the class as an entity and map to the database entity
@Entity
@Table(name="instructor_detail")
public class InstructorDetail 
{
	// 2. define the fields and annotate the fields with db column names
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	
	// 3. create no-args constructor
	public InstructorDetail() 
	{
	
	}

	// 4. parameterized constructor
	public InstructorDetail(String youtubeChannel, String hobby) 
	{
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	// 5. generate getter/setter methods

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getYoutubeChannel() {
		return youtubeChannel;
	}


	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	// 6. generate toString() method
	@Override
	public String toString()
	{
		return "instructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
}
