package com.inf.khproject.service;

import com.inf.khproject.vo.ApproveResponse;
import com.inf.khproject.vo.ReadyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Log4j2
public class KakaoPayServiceImpl implements KakaoPayService {

    @Override
    public ReadyResponse payReady(int totalAmount) {

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.add("cid", "TC0ONETIME");
        parameters.add("partner_order_id", username);
        parameters.add("partner_user_id", "inf");
        parameters.add("item_name", "견적결제");
        parameters.add("quantity", "1");
        parameters.add("total_amount", String.valueOf(totalAmount*10000));
        parameters.add("tax_free_amount", "0");
        parameters.add("approval_url", "http://localhost:8080/order/pay/completed");
        parameters.add("cancel_url", "http://localhost:8080/order/pay/cancel");
        parameters.add("fail_url", "http://localhost:8080/order/pay/fail");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // 외부url요청 통로 열기.
        RestTemplate template = new RestTemplate();
        String url = "https://kapi.kakao.com/v1/payment/ready";

        // template으로 값을 보내고 받아온 ReadyResponse값 readyResponse에 저장.
        ReadyResponse readyResponse = template.postForObject(url, requestEntity, ReadyResponse.class);
        log.info(readyResponse);

        return readyResponse;

    }

    @Override
    public ApproveResponse payApprove(String tid, String pgToken) {

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();

        // request 값 담기
        LinkedMultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", "TC0ONETIME");
        parameters.add("tid", tid);
        parameters.add("partner_order_id", username);
        parameters.add("partner_user_id", "inf");
        parameters.add("pg_token", pgToken);

        // 하나의 map 안에 header와 parameter 값을 담아줌
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // 외부url 통신
        RestTemplate template = new RestTemplate();
        String url = "https://kapi.kakao.com/v1/payment/approve";

        // 보낼 외부 url, 요청 메시지(header,parameter), 처리후 값을 받아올 클래스
        ApproveResponse approveResponse = template.postForObject(url, requestEntity, ApproveResponse.class);
        log.info("결제승인 응답객체: " + approveResponse);

        return approveResponse;

    }

    @Override
    public HttpHeaders getHeaders() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK 5d0505d0b5dfa794f979a2b4d2fc26c4");
        headers.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        return headers;

    }
}
