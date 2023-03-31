package inflearn.jpashop.service;

import inflearn.jpashop.domain.Member;
import inflearn.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    public void 회원가입(){
    //given
        Member member = new Member();
        member.setName("park2");

        //when
        Long saveId = memberService.join(member);

        //then
        assertThat(member).isEqualTo(memberRepository.findOne(saveId));

    }

    @Test
    public void 중복회원예외() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("park1");
        Member member2 = new Member();
        member2.setName("park1");
        //when
        memberService.join(member1);
        try{
            memberService.join(member2);
        }catch(IllegalArgumentException e){
            return;
        }

        //then


    }
}