package hello.springdbjdbc.service;

import hello.springdbjdbc.domain.Member;
import hello.springdbjdbc.repository.MemberRepositoryV1;
import hello.springdbjdbc.repository.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
*  트랜잭션 - 파라미터 연동 , 풀을 이용한 종료
* */
@Slf4j
@RequiredArgsConstructor
public class MemberServiceV2 {

    private final DataSource dataSource;

    private final MemberRepositoryV2 memberRepository;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        Connection con = dataSource.getConnection();

        try {
            con.setAutoCommit(false); // 트랜잭션 시작

            bizLogic(con, fromId, toId, money);
            con.commit();
        }catch (Exception e){
            con.rollback();
            throw new IllegalStateException(e);
        }finally {
            release(con);
        }

    }

    private void bizLogic(Connection con, String fromId, String toId, int money) throws SQLException {
        // 비즈니스 로직
        Member fromMember = memberRepository.findById(con, fromId);
        Member toMember = memberRepository.findById(con, toId);

        memberRepository.update(fromId, fromMember.getMoney() - money);
        validation(toMember);
        memberRepository.update(toId, toMember.getMoney() + money);
    }

    private static void release(Connection con) {
        if (con !=null){
            try {
                con.setAutoCommit(true);
            }catch (Exception e){
                log.info("error ",e);
            }
        }
    }

    private static void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체 중 예외 발생");
        }
    }
}
