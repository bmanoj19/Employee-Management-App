package com.emp_manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emp_manage.DTO.DeptDto;
import com.emp_manage.DTO.DeptEmpDto;
import com.emp_manage.DTO.ResponseDto;
import com.emp_manage.entity.Emp;
import com.emp_manage.service.EmpServiceImpl;

@Controller
public class EmpController {
	@Autowired
	EmpServiceImpl es;
	
	
//List of All Employees
	@GetMapping("/employees")
	public String viewAllEmployees(Model model) {
	    List<ResponseDto> employees = es.getemps();
	    model.addAttribute("employees", employees);
	    return "employeeList";
	}
	
//Employee by Id
	@GetMapping("/employees/{id}")
    public String viewEmployee(@PathVariable("id") int id, Model model) {
		ResponseDto rdt = es.getEmpDept(id);
		
		Emp employee = rdt.getEmployee();
		DeptDto department = rdt.getDepartment();
		
        model.addAttribute("employee", employee);
        model.addAttribute("department", department);
        return "employeeView";
    }
	
//Add Employee
	@GetMapping("/employees/add")
	public String showAddEmployeeForm(Model model) {
	    model.addAttribute("employee", new Emp());
	    return "addEmployee"; 
	}

	// Process Add Employee Form Submission
	@PostMapping("/employees/add")
	public String addEmployee(@ModelAttribute("employee") Emp employee) {
	    es.adding(employee);
	    return "redirect:/employees";
	}
	
//Update Employee
	@GetMapping("/employees/edit/{id}")
	public String showEditEmployeeForm(@PathVariable("id") int id, Model model) {
	    Emp employee = es.getemp(id);
	    if (employee != null) {
	        model.addAttribute("employee", employee);
	        return "editEmployee";
	    } else {
	        // Handle the case where the employee does not exist
	        return "redirect:/employees";
	    }
	}
	
	@PostMapping("/employees/edit/{id}")
	public String updateEmployee(@PathVariable("id") int id, @ModelAttribute("employee") Emp updatedEmployee) {
	    Emp existingEmployee = es.getemp(id);
	    if (existingEmployee != null) {
	        existingEmployee.setName(updatedEmployee.getName());
	        existingEmployee.setCity(updatedEmployee.getCity());
	        existingEmployee.setEmail(updatedEmployee.getEmail());
	        existingEmployee.setdeptid(updatedEmployee.getdeptid());
	        es.update(existingEmployee);
	        return "redirect:/employees";
	    } else {
	        // Handle the case where the employee does not exist
	        return "redirect:/employees";
	    }
	}

//Delete
	@DeleteMapping("/employees/delete/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
		try {
            es.delemp(id);
            return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

	
	@PostMapping("emp")
	public Emp add(@RequestBody Emp e) {
		return es.adding(e);
	}
	
	@GetMapping("emp")
	public Emp getemp(@RequestParam("id") int id) {
		return es.getemp(id);
	}

	@GetMapping("emps")
	public List<Emp> getall() {
		return es.getall();
	}

	@GetMapping("empbyname/{name}")
	public Emp getbyname(@PathVariable("name") String name) {
		return es.getempbyname(name);
	}

	@DeleteMapping("emp")
	public Emp deleteemp(@RequestParam("id") int id) {
		return es.delemp(id);
	}

	@PutMapping("emp")
	public Emp update(@RequestBody Emp e) {
		return es.update(e);
	}
	
	@GetMapping("empdept")
	@ResponseBody
	public ResponseDto getempdept(@RequestParam("id") int id) {
		return es.getEmpDept(id);
	}
	
	@GetMapping("allemp")
	@ResponseBody
	public List<ResponseDto> getallemp(){
		return es.getemps();
	}
	
	@GetMapping("allemploy/{deptid}")
	@ResponseBody
	public List<Emp> getdept(@PathVariable("deptid") int deptid){
		return es.getemploy(deptid);
	}
	
	@GetMapping("alldept")
	@ResponseBody
	public List<DeptEmpDto> gets(){
		return es.getdeptemp();
	}
}
