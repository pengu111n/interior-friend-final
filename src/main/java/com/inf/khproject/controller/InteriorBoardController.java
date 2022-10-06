package com.inf.khproject.controller;

import com.inf.khproject.dto.InteriorBoardDTO;
import com.inf.khproject.dto.InteriorPageRequestDTO;
import com.inf.khproject.service.InteriorBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/interiorboard")
@Log4j2
@RequiredArgsConstructor
public class InteriorBoardController {

    private final InteriorBoardService interiorBoardService;

    @GetMapping("/")
    public String index() {
            return "redirect:/interiorboard/list2";
    }

    @GetMapping("/register")
    public void register()  {
        log.info("regiser get...");
    }

    @PostMapping("/register")
    public String registerPost(InteriorBoardDTO dto, RedirectAttributes redirectAttributes){

        log.info("dto..." + dto);

        //새로 추가된 엔티티의 번호
        Long boardNo = interiorBoardService.register(dto);

        redirectAttributes.addFlashAttribute("msg", boardNo);

        return "redirect:/interiorboard/list";
    }
    @GetMapping(value = "/list")
    public void list(InteriorPageRequestDTO pageRequestDTO, Model model) {
        log.info("Listing interior");
        model.addAttribute("result",interiorBoardService.getList(pageRequestDTO));
    }
    @GetMapping({"/read", "/modify"})
    public void read(long boardNo, @ModelAttribute("requestDTO") InteriorPageRequestDTO requestDTO, Model model ){

        log.info("boardNo: " + boardNo);

        InteriorBoardDTO dto = interiorBoardService.read(boardNo);

        model.addAttribute("dto", dto);

    }

   

}
