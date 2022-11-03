package com.inf.khproject.controller;

import com.inf.khproject.entity.Member;
import com.inf.khproject.security.dto.OAuth2Userimpl;
import com.inf.khproject.security.service.CustomMemberDetails;
import com.inf.khproject.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/remove")
    public void remove()throws Exception{

    };

    @DeleteMapping(value = "/remove/{id}")
    public String remove(@PathVariable Long id) throws Exception {

            service.deleteMember(id);

        SecurityContextHolder.clearContext();

        return "redirect:/";
    }
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
