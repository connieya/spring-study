package study.demo.domain.employee;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Insert("insert into employee(company_id , employee_name , employee_address) values(#{employee.companyId} , #{employee.name}, #{employee.address})" )
    @Options(useGeneratedKeys = true , keyProperty = "id")
    int insert(@Param("employee") Employee employee);

    @Select("select * from employee")
    @Results(id="EmployeeMap", value = {
            @Result(property = "companyId", column = "company_id"),
            @Result(property = "name", column = "employee_name"),
            @Result(property = "address", column = "employee_address")
    })
    List<Employee> getAll();

    @Select("select * from employee where id=#{id}")
    @ResultMap("EmployeeMap")
    Employee getById(@Param("id") int id);

}
