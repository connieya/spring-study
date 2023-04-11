package in.b2tech.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
	
	@RequestMapping("/")
	private String index() {
		return "list-employees";
	}
}
