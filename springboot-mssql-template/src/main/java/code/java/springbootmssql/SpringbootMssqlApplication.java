package code.java.springbootmssql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class SpringbootMssqlApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMssqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "select * from customers";
        List<Customer> customers = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));

        customers.forEach(System.out:: println);
    }
}
