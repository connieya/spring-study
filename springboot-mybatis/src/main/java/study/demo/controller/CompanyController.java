package study.demo.controller;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.demo.domain.Company;
import study.demo.domain.CompanyMapper;

@RestController
@RequestMapping("/company")
@Configuration
public class CompanyController {

    @Resource
    private CompanyMapper companyMapper;

    @PostMapping("")
    public int post(@RequestBody Company company){
        System.out.println("company@@@@ = " + company.getName() + company.getAddress());
        return companyMapper.insert(company);
    }
}
