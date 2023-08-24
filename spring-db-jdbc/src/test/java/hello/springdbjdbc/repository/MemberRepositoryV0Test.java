package hello.springdbjdbc.repository;

import hello.springdbjdbc.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;


class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();
    @Test
    void crud() throws SQLException {
        Member member = new Member("member2", 30000);
        repository.save(member);

        Member findMember = repository.findById(member.getMemberId());
        Assertions.assertThat(findMember).isEqualTo(member);


    }
}