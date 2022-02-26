package com.student.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.student.exception.DatabaseException;
import com.student.model.StudentDetails;
import com.student.service.StudentBOImpl;

@Controller
public class StudentController {

	@Autowired
	StudentBOImpl studentbo;

	//Returns login page
	@GetMapping("/login")
	public String login() {
		System.out.println("inside LOgin");
		return "loginpage";
	}
	

	//Checks login details
	@PostMapping("/login")
	public String loginCheck(@RequestParam String userid, @RequestParam String password, Model model) {
		if (userid.equals("admin") && password.equals("admin")) {
			System.out.println(userid);
			return "homepage";} // returns to home page for matching details
		else
			model.addAttribute("errormsg", "Invalid credentials");
		    return "loginpage"; // returns to login page for non-matching details
	}
    
	
	//Returns the insert page
	@GetMapping("/insert")
	public String showInsertPage(@ModelAttribute("studentdetails") StudentDetails studentdetails, Model model) {
		model.addAttribute("options", Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));
		return "insertpage";
	}

	
	//Inserts student details
	@PostMapping("/insert")
	public String insertDetails(@Valid @ModelAttribute("studentdetails") StudentDetails studentdetails,
			BindingResult br, Model model) throws SQLIntegrityConstraintViolationException{
		if (br.hasErrors()) {
			model.addAttribute("options", Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));
			return "insertpage";
		}
		studentbo.insertDetails(studentdetails);
		model.addAttribute("msg","Sucessfully inserted");
		return "homepage";

	}
    
	
	//Shows the list of Student's details
	@GetMapping("/show")
	public String showDetails(Model model) throws EmptyResultDataAccessException{
		List<StudentDetails> studentdetails = studentbo.showDetails();		
		model.addAttribute("list", studentdetails);
		return "homepage";
	}
    
	
	//Deletes the particular student details by getting the register no.
	@GetMapping("/delete")
	public String deleteDetails(@RequestParam String regno) throws DatabaseException {
		int rows = studentbo.deleteDetails(regno);
		if(rows<1)
			throw new DatabaseException();
		return "redirect:/show";
	}
    
	//Returns the update page populated with student details
	@GetMapping("/update")
	public String updateRequest(@RequestParam String regno, Model model) {
		StudentDetails studentdetails = studentbo.updateRequest(regno);
		model.addAttribute("studentdetails", studentdetails);
		model.addAttribute("options", Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));

		return "updatepage";
	}
    
	
	//Updates the student details
	@PostMapping("/update")
	public String updateDetails(@Valid @ModelAttribute("studentdetails") StudentDetails studentdetails,
			BindingResult br, Model model) throws DatabaseException {
		if(br.hasErrors()) {
			model.addAttribute("options", Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));
		    return "updatepage";}
		int rows = studentbo.updateDetails(studentdetails);
		if(rows<1)
			throw new DatabaseException();
		model.addAttribute("msg","Sucessfully updated");
		return "homepage";
	}
    
	
	//Returns the details of particular student 
	@GetMapping("/search")
	public String searchStudent(@RequestParam String regno, Model model) throws EmptyResultDataAccessException{
		StudentDetails student = studentbo.searchStudent(regno);
		model.addAttribute("student", student);
		return "homepage";
	}
	
	
	//Gets back to home page
	@GetMapping("/home")
	public String getHome() {
		return "homepage";
	}

}
