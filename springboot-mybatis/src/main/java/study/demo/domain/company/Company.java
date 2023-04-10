package study.demo.domain.company;

import lombok.Data;
import study.demo.domain.employee.Employee;

import java.util.List;

@Data
public class Company {
    private int id;
    private String name;
    private String address;
    private List<Employee> employeeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
