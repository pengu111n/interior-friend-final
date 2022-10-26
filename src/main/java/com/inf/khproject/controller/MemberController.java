package com.inf.khproject.controller;




import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.repository.MemberRepository;
import com.inf.khproject.security.service.CustomMemberDetailService;
import com.inf.khproject.security.service.MemberService;
import jdk.jfr.ContentType;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:8080"})
public class MemberController {

    private final MemberService service;

    @GetMapping("/register")
    public void regist(Model model) throws Exception {
        log.info("register");
    }
//, produces = "application/json; charset=utf-8"
    @PostMapping("/register")
public String regist(MemberDTO dto, HttpServletResponse res, HttpServletRequest req, @RequestParam String yy, @RequestParam String mm, @RequestParam String dd) throws Exception {
    log.info("dtoooo" + dto);
    dto.setBirth(yy+"/"+mm+"/"+dd);
    service.register(dto);
    return "redirect:/";
}

    @PostMapping("/confirmMail")
    @ResponseBody
    public String confirmMail(String email, Model model) throws Exception {
        String auth = service.sendSimpleMessage(email);
        return auth;
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

    @PutMapping("/login")
    public void login() throws Exception{
        log.info("login");
    }


    @GetMapping(value = "/loginerror")
    public String loginError(@RequestParam(value = "error", required = false) String error,
                             @RequestParam(value = "exception", required = false) String exception,
                             Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "/member/login";
    }

    @GetMapping(value = "/logout")
    public void logout(){
        log.info("logout....");

    }

    @GetMapping(value="/findID")
    public void findID() {
        log.info("findID...");
    }

    @PostMapping(value = "/findID")
    @ResponseBody
    public String findID(Model model, String name, String phoneNum) throws Exception{
        String username = service.findUsername(name, phoneNum);
        model.addAttribute("username", username);
        return username;
    }

    @GetMapping(value="/findPW")
    public void findPW() {
        log.info("findPW...");
    }


    @PostMapping(value="/findPW")
    public String findPW(Model model, String name, String username, String email) throws Exception {
        ResponseEntity<String> entity = null;
        try {
            service.tempPW(name, username, email);
            model.addAttribute("success", "변경된 비밀번호로 입력 해 주세요.");
            entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
            return "/member/login";
        }catch (Exception e){
            model.addAttribute("error", e.getMessage());
            entity = new ResponseEntity<> (e.getMessage(), HttpStatus.BAD_REQUEST);
            return "/member/findPW";
        }

    }



}






