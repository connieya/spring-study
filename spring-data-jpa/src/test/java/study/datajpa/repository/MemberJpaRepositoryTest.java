package study.datajpa.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @Autowired MemberJpaRepository memberJpaRepository;

    @Test
    public void Test(){
    //given
        Member member = new Member("memberA");

    //when
        Member save = memberJpaRepository.save(member);
        //then
        Member findMember = memberJpaRepository.find(save.getId());
        Assertions.assertThat(save.getId()).isEqualTo(findMember.getId());

    }

}