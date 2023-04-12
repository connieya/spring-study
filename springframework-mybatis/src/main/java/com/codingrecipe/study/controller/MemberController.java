package com.codingrecipe.study.controller;

import com.codingrecipe.study.dto.MemberDTO;
import com.codingrecipe.study.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO){
        int saveResult = memberService.save(memberDTO);
        if (saveResult > 0){
            return "login";
        }else {
            return "save";
        }
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO , HttpSession session) {
        boolean loignResult = memberService.login(memberDTO);
        if (loignResult){
            session.setAttribute("loginEmail",memberDTO.getMemberEmail());
            return "main";
        }else{
            return "login";
        }
    }
}
