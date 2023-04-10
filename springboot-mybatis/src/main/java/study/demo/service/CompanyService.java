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
    @Autowired
    private EmployMapper

    public List<Company> getAll(){
       List<Company> companyList = companyMapper.getAll();
       if (companyList != null &&  companyList.size() > 0) {
           for (Company company : companyList) {
               company.setEmployeeList(companyMapper.getById(company.getId()));
           }
       }
       return companyList;
    }

}
