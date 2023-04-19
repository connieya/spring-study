package study.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.demo.domain.company.Company;
import study.demo.domain.company.CompanyMapper;
import study.demo.domain.employee.EmployeeMapper;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Company> getAll() {
        List<Company> companyList = companyMapper.getAll();
        if (companyList != null && companyList.size() > 0) {
            for (Company company : companyList) {
                company.setEmployeeList(companyMapper.getByCompanyId(company.getId()));
            }
        }
        return companyList;
    }

    @Transactional(rollbackFor = Exception.class)
    public Company add(Company company) throws Exception {
        companyMapper.insert(company);
        if (true) {
            throw new Exception("Legacy Exception");
        }
        return company;
    }

}
