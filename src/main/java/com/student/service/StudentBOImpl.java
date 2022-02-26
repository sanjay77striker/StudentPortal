package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.StudentDetails;
import com.student.repository.StudentDAOImpl;

@Service
public class StudentBOImpl implements StudentBO {

	@Autowired
	StudentDAOImpl studentdao;

	// inserts student details
	public int insertDetails(StudentDetails studentdetails) {
		int rows = studentdao.insertDetails(studentdetails);
		return rows;
	}

	// shows the students' information
	public List<StudentDetails> showDetails() {
		List<StudentDetails> studentdetails = studentdao.showDetails();
		return studentdetails;
	}

	// deletes the record of particular student
	public int deleteDetails(String regno) {
		int rows = studentdao.deleteDetails(regno);
		return rows;
	}

	// gets the details of particular student for updating
	public StudentDetails updateRequest(String regno) {
		StudentDetails studentdetails = studentdao.updateRequest(regno);
		return studentdetails;
	}

	// updates the record of particular student
	public int updateDetails(StudentDetails studentdetails) {
		int rows = studentdao.updateDetails(studentdetails);
		return rows;
	}

	// finds the details of particular student
	public StudentDetails searchStudent(String regno) {
		StudentDetails student = studentdao.searchStudent(regno);
		return student;
	}

}
