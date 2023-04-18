package code.java.springbootmssql;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;


@Slf4j
@SpringBootTest
public class DbTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void connection() throws SQLException {
        try(Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            log.info("URL : " + metaData.getURL());
            log.info("DriverName : " + metaData.getDriverName());
            log.info("UserName : " + metaData.getUserName());
        }
    }
 }
