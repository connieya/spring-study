package in.b2tech.springmvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import in.b2tech.springmvc.entity.Employee;
import in.b2tech.springmvc.util.MyBatisUtil;

@Repository
public class EmployeeMapper {

	public List<Employee> getAllEmployees() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Employee> employees = session.selectList("getAllEmployees");
		session.commit();
		session.close();
		return employees;
	}

	public void saveEmployee(Employee employee) {

		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("insertEmployee", employee);
		session.commit();
		session.close();
	}

	public void deleteEmployee(int employeeId) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("deleteEmployee", employeeId);
		session.commit();
		session.close();
	}

	public Employee findById(int employeeId) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Employee employee = (Employee) session.selectOne("findById", employeeId);
		session.commit();
		session.close();
		return employee;
	}

	public void updateEmployee(Employee employee) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("updateEmployee", employee);
		session.commit();
		session.close();
	}

}
