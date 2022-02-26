package com.student.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class StudentDetails {

	@Pattern(regexp = "[0-9]{6,}", message = "Should contain atleast 6 digits")
	private String regno;
	@Pattern(regexp = "[a-zA-Z\\s]{1,}", message = "Should contain only alphabets")
	private String name;
	@Past(message = "incorrect date of birth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "please select the date of birth")
	private LocalDate dob;

	@Pattern(regexp = "[0-9]{10}", message = "Should contain only 10 digits")
	private String mobileno;
	@NotEmpty(message = "Gender should not be empty")
	private String gender;
	@NotNull(message = "please select the standard")
	private int std;
	@Pattern(regexp = "[a-zA-Z\\s]{1,}", message = "Should contain only alphabets")
	private String hometown;

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getStd() {
		return std;
	}

	public void setStd(int std) {
		this.std = std;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

}
