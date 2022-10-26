package com.inf.khproject.controller;

import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.entity.Member;
import com.inf.khproject.repository.MemberRepository;
import com.inf.khproject.security.dto.MemberAuthDTO;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j2
public class HomeController {

    @Autowired
    MemberRepository repository;
    @Autowired
    PasswordEncoder passwordEncoder;


    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        Member member2 = repository.findByUsername("admin")
                .map(entity -> entity.admin("admin", passwordEncoder.encode("admin"), "admin@admin.com"))
                .orElse(Member.builder()
                        .username("admin")
                        .pw(passwordEncoder.encode("admin"))
                        .email("admin@admin.com").build());


        repository.save(member2);

        log.info("Welcome home! The client locale is {}.", locale);
        return "/main/index";
    }

    @RequestMapping(value = "/main/introduce", method = RequestMethod.GET)
    public void introduce() throws Exception {

    }


    @RequestMapping(value = "/notice/faq", method = RequestMethod.GET)
    public String faq(Locale locale, Model model) {
        return "/notice/faq";

    }

    @RequestMapping(value = "/users/notAdmin", method = RequestMethod.GET)
    public String notAdmin(Locale locale, Model model) {
        return "/users/notAdmin";

    }


    @RequestMapping(value = "/users/notLogin", method = RequestMethod.GET)
    public String notLogin(Locale locale, Model model) {
        return "/users/notLogin";

    }

}
