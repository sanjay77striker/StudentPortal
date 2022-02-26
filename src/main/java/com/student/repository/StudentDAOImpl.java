package com.student.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.student.model.StudentDetails;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	JdbcTemplate jt;

	// inserts student details
	public int insertDetails(StudentDetails studentdetails) {
		String sql = "insert into student values ('" + studentdetails.getRegno() + "','" + studentdetails.getName()
				+ "','" + java.sql.Date.valueOf(studentdetails.getDob()) + "','" + studentdetails.getMobileno() + "','"
				+ studentdetails.getGender() + "','" + studentdetails.getStd() + "','" + studentdetails.getHometown()
				+ "')";
		int rows = jt.update(sql);
		return rows;
	}

	// shows the students' information
	public List<StudentDetails> showDetails() {
		String sql = "select * from student";
		List<StudentDetails> studentdetails = jt.query(sql, new StudentRowMapper());
		return studentdetails;
	}

	// deletes the record of particular student
	public int deleteDetails(String regno) {
		String sql = "delete from student where regno=?";
		int rows = jt.update(sql, regno);
		return rows;
	}

	// gets the details of particular student for updating
	public StudentDetails updateRequest(String regno) {
		String sql = "select * from student where regno='" + regno + "'";
		StudentDetails studentdetails = jt.queryForObject(sql, new StudentRowMapper());
		return studentdetails;
	}

	// updates the record of particular student
	public int updateDetails(StudentDetails studentdetails) {
		String sql = "update student set name='" + studentdetails.getName() + "',dob='"
				+ java.sql.Date.valueOf(studentdetails.getDob()) + "',mobile='" + studentdetails.getMobileno()
				+ "',gender='" + studentdetails.getGender() + "',std=" + studentdetails.getStd() + ",hometown='"
				+ studentdetails.getHometown() + "' where regno='" + studentdetails.getRegno() + "'";
		int rows = jt.update(sql);
		return rows;
	}

	// finds the details of particular student
	public StudentDetails searchStudent(String regno) {
		String sql = "select * from student where regno='" + regno + "'";
		StudentDetails student = jt.queryForObject(sql, new StudentRowMapper());
		return student;
	}

}
