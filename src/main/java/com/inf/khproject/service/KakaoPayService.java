package com.inf.khproject.service;

import com.inf.khproject.vo.ApproveResponse;
import com.inf.khproject.vo.ReadyResponse;
import org.springframework.http.HttpHeaders;

public interface KakaoPayService {

    ReadyResponse payReady(int totalAmount);

    ApproveResponse payApprove(String tid, String pgToken);

    HttpHeaders getHeaders();

}
