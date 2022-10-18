package com.inf.khproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
@RequestMapping("/applicationboard/read")
public class KakaoPayController {

//    private final KakaoPayService kakaoPayService;

    @RequestMapping("/jq.cls")
    public ModelAndView main(ModelAndView mv, HttpSession s, RedirectView rv) {
        mv.setViewName("applicationboard/read");
        return mv;
    }

    @RequestMapping("/pay.cls")
    public ModelAndView serve(ModelAndView mv, HttpSession s, RedirectView redirectView) {
        mv.setViewName("applicationboard/read");
        return mv;
    }

    @RequestMapping("/kakaopay.cls")
    @ResponseBody
    public String kakaopay() {

        try {
            URL address = new URL("https://kapi.kakao.com/v1/payment/ready");
            HttpURLConnection httpURLConnection = (HttpURLConnection) address.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Authorization", "KakaoAK 5d0505d0b5dfa794f979a2b4d2fc26c4");
            httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            httpURLConnection.setDoOutput(true);

            String parameter = "";

            parameter += "cid=TC0ONETIME&";
            parameter += "tid=tid&";
            parameter += "partner_order_id=partner_order_id&";
            parameter += "partner_user_id=partner_user_id&";
            parameter += "pg_token=pg_token&";
            parameter += "item_name=item_name&";
            parameter += "quantity=1&";
            parameter += "total_amount=1&";
            parameter += "tax_free_amount=0&";
            parameter += "approval_url=https://localhost:8080/applicationboard/list&";
            parameter += "cancel_url=https://localhost:8080/applicationboard/list&";
            parameter += "fail_url=https://localhost:8080/applicationboard/list";

            OutputStream outputStream = httpURLConnection.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBytes(parameter);
            dataOutputStream.close();

            int result = httpURLConnection.getResponseCode();

            InputStream inputStream;

            if (result == 200) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            return bufferedReader.readLine();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "{\"result\":\"NO\"}";
    }

}
