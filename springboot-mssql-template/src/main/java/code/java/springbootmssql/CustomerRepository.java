package code.java.springbootmssql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Integer, Customer> {
}
