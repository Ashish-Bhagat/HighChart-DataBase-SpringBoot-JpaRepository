package com.stackInstance.HighChartDatabase.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stackInstance.HighChartDatabase.model.Employee;
import com.stackInstance.HighChartDatabase.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee)
	{
		return service.saveEmployee(employee);
	}

	
	@GetMapping("/barChart")
	public String getAllEmployee(Model model) {	
		
	List<String> nameList= service.getAllEmployee().stream().map(x->x.getName()).collect(Collectors.toList());
	List<Integer> ageList = service.getAllEmployee().stream().map(x-> x.getAge()).collect(Collectors.toList());
	model.addAttribute("name", nameList);
	model.addAttribute("age", ageList);
	return "barChart";
	
	}
}
