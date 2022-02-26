package com.student.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.student.model.StudentDetails;

public class StudentRowMapper implements RowMapper<StudentDetails> {

	@Override
	public StudentDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentDetails sd = new StudentDetails();
		sd.setRegno(rs.getString(1));
		sd.setName(rs.getString(2));
		sd.setDob(rs.getDate(3).toLocalDate());
		sd.setMobileno(rs.getString(4));
		sd.setGender(rs.getString(5));
		sd.setStd(rs.getInt(6));
		sd.setHometown(rs.getString(7));
		return sd;
	}

}

