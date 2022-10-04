package com.inf.khproject.controller;

import com.inf.khproject.dto.ApplicationBoardDTO;
import com.inf.khproject.dto.PageRequestDTO;
import com.inf.khproject.service.ApplicationBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/applicationboard")
@Log4j2
@RequiredArgsConstructor
public class ApplicationBoardController {

    private final ApplicationBoardService applicationBoardService;

    @GetMapping("/")
    public String index() {
            return "redirect:/applicationboard/list";
    }


    @GetMapping(value = "/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("Listing application");
        model.addAttribute("result",applicationBoardService.getList(pageRequestDTO));
    }


   

}
