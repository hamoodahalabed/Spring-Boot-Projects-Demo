package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	EmployeeService employeeService;
	// add mapping for "/list"


	public EmployeeController (EmployeeService theEmployeesService) {
		employeeService = theEmployeesService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees = employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("showFormForAdd")
	public String showFormForAdd (Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee",theEmployee);

		return "employees/employee-form";
	}

	//from controller to view
	@GetMapping("/showFormForUpdate")// this method expect employeeid as part of request
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

		Employee theEmployee = employeeService.findById(theId);
// It essentially makes the employee data available to the view for rendering
		theModel.addAttribute("employee",theEmployee);

		return "employees/employee-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {

		employeeService.deleteById(theId);

		return "redirect:/employees/list";
	}

	//from view to controller
	@PostMapping("/save") // this annotation mean data should be provided from the form
	public String SaveEmployee (@ModelAttribute("employee") Employee theEmployee) {

		employeeService.save(theEmployee);

		return "redirect:/employees/list";
	}
}









