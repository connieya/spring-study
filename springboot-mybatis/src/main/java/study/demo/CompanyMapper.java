package study.demo;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompanyMapper {

    @Insert("insert into company(company_name , company_address values(#(company.name) #(company.address)" )
    int insert(@Param("company") Company company);

}
