package study.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.demo.domain.company.Company;
import study.demo.domain.company.CompanyMapper;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    public List<Company> getAll(){
       List<Company> companyList = companyMapper.getAll();
       return companyList;
    }

}
