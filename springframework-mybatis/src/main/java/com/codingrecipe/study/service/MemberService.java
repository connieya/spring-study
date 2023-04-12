package com.codingrecipe.study.service;


import com.codingrecipe.study.dto.MemberDTO;
import com.codingrecipe.study.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public int save(MemberDTO memberDTO) {
        return memberRepository.save(memberDTO);
    }

    public boolean login(MemberDTO memberDTO) {
        MemberDTO loginMember =memberRepository.login(memberDTO);
        if (loginMember != null){
            return true;
        }
        return false;
    }
}
