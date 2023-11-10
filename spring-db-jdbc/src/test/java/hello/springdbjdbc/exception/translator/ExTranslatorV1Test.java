package hello.springdbjdbc.exception.translator;

import hello.springdbjdbc.domain.Member;
import hello.springdbjdbc.repository.ex.MyDbException;
import hello.springdbjdbc.repository.ex.MyDuplicationKeyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import static hello.springdbjdbc.connection.ConnectionConst.*;

public class ExTranslatorV1Test {

    Repository repository;
    Service service;

    @BeforeEach
    void init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME ,PASSWORD);
        repository = new Repository(dataSource);
        service = new Service(repository);
    }

    @Test
    void duplicateKeySave() {
        service.create("myId");
        service.create("myId");
    }

    static class Service {
        private final Repository repository;

        public Service(Repository repository) {
            this.repository = repository;
        }

        public void create(String memberId) {

            try {
                repository.save(new Member(memberId, 0));
                System.out.println("saveId " + memberId);
            } catch (MyDuplicationKeyException e) {
                System.out.println("복구 시도");
                String retryId = generateNewId(memberId);
                System.out.println("retryId = " + retryId);
                repository.save(new Member(retryId,0));
            }catch (MyDbException e) {
                System.out.println("데이터 접근 계층 예외"+e);
            }
        }
        private String generateNewId(String memberId){
            return memberId+new Random().nextInt(10000);
        }
    }



    static class Repository {
        private final DataSource dataSource;

        public Repository(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        public Member save(Member member) {
            String sql = "insert into member(member_id , money) values(?,?)";
            Connection con = null;
            PreparedStatement pstmt = null;

            try {
                con = dataSource.getConnection();
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, member.getMemberId());
                pstmt.setInt(2, member.getMoney());
                pstmt.executeUpdate();
                return member;
            } catch (SQLException e) {
                if (e.getErrorCode() == 23505) {
                    throw new MyDuplicationKeyException(e);
                }
                throw new MyDbException(e);

            } finally {
                JdbcUtils.closeStatement(pstmt);
                JdbcUtils.closeConnection(con);
            }
        }


    }

}
