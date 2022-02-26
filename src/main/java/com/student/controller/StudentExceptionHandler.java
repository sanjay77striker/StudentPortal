package com.student.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.student.exception.DatabaseException;

@ControllerAdvice
public class StudentExceptionHandler {
	
	//handles duplicate values in primary key
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public String handleDuplicateValueException(Model model) {
		model.addAttribute("msg","Already registered can't enter duplicate values");
		return "homepage";
	}
	
	//handles if result set is not found for the query
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public String handleResourceNotFoundException(Model model) {
		model.addAttribute("msg","No data found");
		return "homepage";
	}
	
	//handles for improper update or delete
	@ExceptionHandler(DatabaseException.class)
	public String handleDatabaseException4(Model model) {
		model.addAttribute("msg","Cannot update or delete");
		return "homepage";
	}


}
