package com.inf.khproject.security.handler;

import com.inf.khproject.security.dto.MemberAuthDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class MemberHandler implements AuthenticationSuccessHandler {


        private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();

        private PasswordEncoder passwordEncoder;

        public MemberHandler(){
            passwordEncoder = new BCryptPasswordEncoder();
        }

        public MemberHandler(PasswordEncoder passwordEncoder){
            this.passwordEncoder = passwordEncoder;
        }


        @Override
        public void onAuthenticationSuccess(HttpServletRequest request,
                                            HttpServletResponse response,
                                            Authentication authentication) throws IOException, ServletException {

            log.info("--------------------------------------");
            log.info("onAuthenticationSuccess");

            MemberAuthDTO authMember = (MemberAuthDTO)authentication.getPrincipal();

            boolean fromSocial = authMember.isSocial();

            log.info("Need Modify Member?" + fromSocial);

            boolean passwordResult = passwordEncoder.matches("1111", authMember.getPassword());

            if(fromSocial && passwordResult) {
                redirectStratgy.sendRedirect(request, response, "/member/modify?from=social");
            }
        }



    }

