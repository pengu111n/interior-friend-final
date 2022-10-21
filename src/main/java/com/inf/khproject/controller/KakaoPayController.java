package com.inf.khproject.controller;

import com.inf.khproject.service.KakaoPayService;
import com.inf.khproject.vo.ApproveResponse;
import com.inf.khproject.vo.ReadyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@SessionAttributes({"tid", "boardNo"})
@RequiredArgsConstructor
public class KakaoPayController {

    private final KakaoPayService kakaoPayService;

    // 카카오페이결제 요청
    @GetMapping("/order/pay")
    public @ResponseBody ReadyResponse payReady(@RequestParam(name = "total_amount") int totalAmount, @RequestParam(name = "board_no") Long boardNo, Model model) {

        log.info("주문정보:"+boardNo);
        log.info("주문가격:"+totalAmount);

        // 카카오 결제 준비하기	- 결제요청 service 실행.
        ReadyResponse readyResponse = kakaoPayService.payReady(totalAmount);

        // 요청처리후 받아온 결재고유 번호(tid)를 모델에 저장
        model.addAttribute("tid", readyResponse.getTid());
        log.info("결재고유 번호: " + readyResponse.getTid());

        // Order정보를 모델에 저장
        model.addAttribute("boardNo", boardNo);

        return readyResponse; // 클라이언트에 보냄.(tid,next_redirect_pc_url이 담겨있음.)
    }

    // 결제승인요청
    @GetMapping("/order/pay/completed")
    public String payCompleted(@RequestParam("pg_token") String pgToken, @ModelAttribute("tid") String tid, @ModelAttribute("boardNo") Long boardNo) {

        log.info("결제승인 요청을 인증하는 토큰: " + pgToken);
        log.info("주문정보: " + boardNo);
        log.info("결재고유 번호: " + tid);

        // 카카오 결재 요청하기
        ApproveResponse approveResponse = kakaoPayService.payApprove(tid, pgToken);

        return "redirect:/applicationboard/completepayment?boardNo=" + boardNo;
    }

    // 결제 취소시 실행 url
    @GetMapping("/order/pay/cancel")
    public String payCancel() {
        return "redirect:/applicationboard/list";
    }

    // 결제 실패시 실행 url
    @GetMapping("/order/pay/fail")
    public String payFail() {
        return "redirect:/applicationboard/list";
    }

}
