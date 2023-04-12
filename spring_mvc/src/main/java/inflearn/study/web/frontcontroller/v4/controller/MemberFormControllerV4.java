package inflearn.study.web.frontcontroller.v4.controller;

import inflearn.study.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> map) {
       return "new-form";
    }
}
