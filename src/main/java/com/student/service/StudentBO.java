package com.student.service;

import java.util.List;

import com.student.model.StudentDetails;

public interface StudentBO {
	
	//inserts student details
	int insertDetails(StudentDetails studentdetails);
	
	//shows the students' information
	List<StudentDetails> showDetails();
	
	//deletes the record of particular student
	int deleteDetails(String regno);
	
	//gets the details of particular student for updating
	StudentDetails updateRequest(String regno);
	
	//updates the record of particular student
	int updateDetails(StudentDetails studentdetails);
	
	//finds the details of particular student
	StudentDetails searchStudent(String regno);

}
