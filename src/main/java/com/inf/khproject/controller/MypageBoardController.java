package com.inf.khproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mypage/member")
@Log4j2
@RequiredArgsConstructor
public class MypageBoardController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list(@RequestParam("memNo") int memNo, Model model) throws Exception {

        log.info("list.....");

    }
}
