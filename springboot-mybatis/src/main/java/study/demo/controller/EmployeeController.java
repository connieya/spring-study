package study.demo.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import study.demo.domain.employee.Employee;
import study.demo.domain.employee.EmployeeMapper;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeMapper employeeMapper;

    @PostMapping("")
    public Employee post(@RequestBody Employee employee){
        employeeMapper.insert(employee);
        return employee;
    }

    @GetMapping("")
    public List<Employee> getAll() {
        return employeeMapper.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") int id){
        return employeeMapper.getById(id);
    }

}
