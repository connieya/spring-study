package study.demo.controller;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import study.demo.domain.Company;
import study.demo.domain.CompanyMapper;

import java.util.List;

@RestController
@RequestMapping("/company")
@Configuration
public class CompanyController {

    @Resource
    private CompanyMapper companyMapper;

    @PostMapping("")
    public int post(@RequestBody Company company){
        return companyMapper.insert(company);
    }

    @GetMapping("")
    public List<Company> getAll() {
        return companyMapper.getAll();
    }
}
