package com.inf.khproject.controller;

import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.entity.Member;
import com.inf.khproject.security.dto.OAuth2Userimpl;
import com.inf.khproject.security.service.CustomMemberDetails;
import com.inf.khproject.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
@CrossOrigin(origins = {"http://localhost:8080"})
@Log4j2
public class MemberApiController {

    private final MemberService service;
    @Autowired
    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    @PutMapping(value = "/modify")
    public ResponseEntity<String> modify(@RequestBody Member member, RedirectAttributes rttr, HttpServletRequest request, @AuthenticationPrincipal OAuth2Userimpl oAuth2Userimpl, @AuthenticationPrincipal CustomMemberDetails customMemberDetails, @RequestParam(value = "rank1" , required=false)String rank1, @RequestParam(value = "rank" , required=false)String rank) throws Exception {
        String password = member.getPw();
        log.info("member*****전 : " + member);

        Member member1 = service.modify(member);

        log.info("member*****후 : " + member);

        log.info("authentication***********" +  SecurityContextHolder.getContext());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(member1.getUsername(), password));
        SecurityContextHolder.getContext().setAuthentication(authentication);


        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/login")
    public void login(Model model) throws Exception{

    }

    @PutMapping("/login")
    public void login() throws Exception{

    }
}
