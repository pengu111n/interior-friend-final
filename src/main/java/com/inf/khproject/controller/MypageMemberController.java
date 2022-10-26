package com.inf.khproject.controller;

import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.entity.Member;
import com.inf.khproject.security.dto.OAuth2Userimpl;
import com.inf.khproject.security.service.CustomMemberDetails;
import com.inf.khproject.security.service.MemberService;
import com.inf.khproject.security.service.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/mypage/member")
@Log4j2
@RequiredArgsConstructor
public class MypageMemberController {

    private final MemberService service;
    private final AuthenticationManager authenticationManager;
    @GetMapping(value = "/get")
    public String get(Model model, @AuthenticationPrincipal OAuth2Userimpl oAuth2Userimpl, @AuthenticationPrincipal CustomMemberDetails customMemberDetails) throws Exception {

        Member member = null;
        if(oAuth2Userimpl != null) {
            member = oAuth2Userimpl.getMember();
            log.info("attribute..." + member);
        }else{
            member = customMemberDetails.getMember();
        }
        model.addAttribute("login", member);


        return "/mypage/member/get";
    }

//    @RequestMapping(value = "/remove", method = RequestMethod.POST)
//    public String remove(@RequestParam("memno") int memno, RedirectAttributes rttr) throws Exception {
//
//        service.remove(memno);
//
//        rttr.addFlashAttribute("result", "success");
//
//        return "redirect:/";
//    }
//
    @GetMapping(value = "/modify")
    public void modifyGET(@AuthenticationPrincipal OAuth2Userimpl oAuth2Userimpl, @AuthenticationPrincipal CustomMemberDetails customMemberDetails, Model model) throws Exception {



    }

//    @PostMapping(value = "/mypage/member/modify")
//    public ResponseEntity<String> modifyPOST(@RequestBody MemberDTO dto, RedirectAttributes rttr, HttpServletRequest request, @AuthenticationPrincipal OAuth2Userimpl oAuth2Userimpl, @AuthenticationPrincipal CustomMemberDetails customMemberDetails, @RequestParam("rank1")String rank) throws Exception {
//
//        Member member = null;
//        if(oAuth2Userimpl != null) {
//            member = oAuth2Userimpl.getMember();
//
//        }else{
//            member = customMemberDetails.getMember();
//        }
//        if(rank == "개인"){
//            dto.setRank(1);
//        }else if(rank == "기업"){
//            dto.setRank(2);
//        }else if(rank == "관리자") {
//            dto.setRank(3);
//        }
//        service.modify(member, dto);
//
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPw()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//
//        return new ResponseEntity<>("success", HttpStatus.OK);
//    }
}
