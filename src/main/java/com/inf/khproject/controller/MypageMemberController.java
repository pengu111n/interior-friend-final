package com.inf.khproject.controller;

import com.inf.khproject.entity.Member;
import com.inf.khproject.security.service.CustomMemberDetails;
import com.inf.khproject.security.service.MemberService;
import com.inf.khproject.security.service.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
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



    @GetMapping(value = "/get")
    public String get(Model model, @AuthenticationPrincipal CustomMemberDetails customMemberDetails) throws Exception {

//        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//
//        Object principal = loggedInUser.getPrincipal();
//
//        log.info("member2........." + principal);
//
//        OAuth2User oAuth2User = null;
//        if (principal instanceof OAuth2AuthenticationToken) {
//            OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) principal;
//            //By default its DefaultOAuth2User.
//            oAuth2User = oAuth2AuthenticationToken.getPrincipal();
//        }
//
//        Map<String, Object> attributes = oAuth2User.getAttributes();
//
//        log.info("attribute...." + attributes);

        log.info("attribute..." + customMemberDetails.getAttributes());

        model.addAttribute("login", customMemberDetails.getAttributes());


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
//    @RequestMapping(value = "/modify", method = RequestMethod.GET)
//    public void modifyGET(int memNo, Model model) throws Exception {
//
//        model.addAttribute(service.get(memNo));
//
//    }
//
//    @RequestMapping(value = "/modify", method = RequestMethod.POST)
//    public String modifyPOST(MemberVO member, RedirectAttributes rttr, HttpServletRequest request) throws Exception {
//
//        logger.info("modify: " + member);
//
//        service.modify(member);
//        MemberVO vo = service.get(member.getMemNo());
//
//        rttr.addFlashAttribute("result", "success");
//        HttpSession session = request.getSession();
//        session.setAttribute("login", vo);
//        return "redirect:/mypage/member/get?memNo="+Integer.toString(member.getMemNo());
//    }
}
