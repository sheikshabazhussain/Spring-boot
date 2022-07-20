package com.employee.employeeapp;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
	@Autowired
EmployeeRepository er;
	
	@PostMapping("/saveEmployee")    //saving data in database
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		Employee employee1 = er.save(employee);
		return employee1;
	}
	
	
	@GetMapping("/getEmployee")   //getting all data from database
	
	public List<Employee> getEmployees()
	{
		return er.findAll();
	}
	
	@PostMapping("/updateEmployee")
		public  Employee updatEmployee(@RequestParam int id, @RequestBody Employee employee)
		{
			Optional<Employee> opt =er.findById(id);
			if(opt.isEmpty())
			{
				return null;
			}
				else 
					{
						return er.save(employee);
					}
				
			}
	
	@DeleteMapping("/deleteEmployee")
	public String DeleteEmployeeById(@RequestParam int id)
	{
		Optional<Employee> opt = er.findById(id);
		if(opt.isEmpty())
		{
			return "No employee to delete";
		}
		else 
		{
		  Employee employee = opt.get();
		  er.delete(employee);
		  return "Employee deleted";
		}
	}
	
		}

	

