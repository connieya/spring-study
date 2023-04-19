package study.demo.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import study.demo.domain.company.Company;
import study.demo.domain.company.CompanyMapper;
import study.demo.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/company")
@Configuration
public class CompanyController {

    @Resource
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyService companyService;

    @PostMapping("")
    public Company post(@RequestBody Company company) throws Exception {
//        companyMapper.insert(company);
        companyService.add(company);
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
