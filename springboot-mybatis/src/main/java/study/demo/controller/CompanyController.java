package study.demo.controller;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import study.demo.domain.company.Company;
import study.demo.domain.company.CompanyMapper;

import java.util.List;

@RestController
@RequestMapping("/company")
@Configuration
public class CompanyController {

    @Resource
    private CompanyMapper companyMapper;

    @PostMapping("")
    public Company post(@RequestBody Company company){
        companyMapper.insert(company);
        return company;
    }

    @GetMapping("")
    public List<Company> getAll() {
        return companyMapper.getAll();
    }
    @GetMapping("/{id}")
    public Company getById(@PathVariable("id") int id){
        return companyMapper.getById(id);
    }
}
