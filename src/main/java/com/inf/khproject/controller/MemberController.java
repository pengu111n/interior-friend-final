package com.inf.khproject.controller;




import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.repository.MemberRepository;
import com.inf.khproject.service.MemberService;
import jdk.jfr.ContentType;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @GetMapping("/register")
    public void regist(Model model) throws Exception {
        log.info("register");
    }

    @PostMapping(value = "/register", produces = "application/json; charset=utf-8")
    public String regist(MemberDTO dto, HttpServletResponse res, HttpServletRequest req) throws Exception {

        service.regist(dto, "sss");
        return "redirect:/";
    }

    @PostMapping("/usernameCheck")
    @ResponseBody
    public int usernameCheck(String username) throws Exception {
        int result = service.usernameCheck(username);
        System.out.println(result);
        return result;
    }

    @PostMapping("/nicknameCheck")
    @ResponseBody
    public int nicknameCheck(String nickname) throws Exception{
        int result = service.nicknameCheck(nickname);
        return result;
    }

    @GetMapping("/login")
    public void login(Model model) throws Exception{
        log.info("login");
    }

    @PostMapping("/login")
    public void login() throws Exception{

    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
        return "/member/login";
    }



}






