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

    @GetMapping("/register")
    public void register()  {
        log.info("regiser get...");
    }

    @PostMapping("/register")
    public String registerPost(ApplicationBoardDTO dto, RedirectAttributes redirectAttributes){

        log.info("dto..." + dto);

        //새로 추가된 엔티티의 번호
        Long boardNo = applicationBoardService.register(dto);

        redirectAttributes.addFlashAttribute("msg", boardNo);

        return "redirect:/applicationboard/list";
    }
    @GetMapping(value = "/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("Listing application");
        model.addAttribute("result",applicationBoardService.getList(pageRequestDTO));
    }

    @GetMapping({"/read", "/modify"})
    public void read(long boardNo, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model ){

        log.info("boardNo: " + boardNo);

        ApplicationBoardDTO dto = applicationBoardService.read(boardNo);

        model.addAttribute("dto", dto);

    }

    @RequestMapping(value="/remove", method = {RequestMethod.GET, RequestMethod.POST})
    public String remove(long boardNo, RedirectAttributes redirectAttributes){


        log.info("boardNo: " + boardNo);
        applicationBoardService.remove(boardNo);

        redirectAttributes.addFlashAttribute("msg", boardNo);

        return "redirect:/applicationboard/list";

    }
   

}
