package in.b2tech.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.b2tech.springmvc.dao.EmployeeMapper;
import in.b2tech.springmvc.entity.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeMapper mapper;
	
	@RequestMapping("/")
	private ModelAndView index() {
		ModelAndView mav = new ModelAndView("list-employees");
		mav.addObject("employeeList",mapper.getAllEmployees());	
		return mav;
	}
	
	@RequestMapping("/showFormForAddEmplotyee")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("add-employee");
		mav.addObject("employee", new Employee());
		return mav;
	}
}
