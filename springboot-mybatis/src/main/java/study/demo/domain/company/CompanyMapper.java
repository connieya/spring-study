package study.demo.domain.company;


import org.apache.ibatis.annotations.*;
import study.demo.domain.employee.Employee;

import java.util.List;

@Mapper
public interface CompanyMapper {

    @Insert("insert into company(company_name , company_address) values(#{company.name}, #{company.address})" )
    @Options(useGeneratedKeys = true , keyProperty = "id")
    int insert(@Param("company") Company company);

    @Select("select * from company")
    @Results(id="CompanyMap", value = {
            @Result(property = "name", column = "company_name"),
            @Result(property = "address", column = "company_address"),
            @Result(property = "employeeList",column = "id" , many = @Many(select="study.demo.domain.company.CompanyMapper.getByCompanyId"))
    })
    List<Company> getAll();

    @Select("select * from company where id=#{id}")
    @ResultMap("CompanyMap")
    Company getById(@Param("id") int id);


    @Select("select * from employee where company_id = #{companyId}")
    @ResultMap("EmployeeMap")
    List<Employee> getByCompanyId(@Param("companyId") int companyId);


}
