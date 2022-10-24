package com.inf.khproject.controller;

import com.inf.khproject.dto.ApplicationBoardDTO;
import com.inf.khproject.dto.ApplicationPageRequestDTO;
import com.inf.khproject.dto.ApplicationPageResultDTO;
import com.inf.khproject.service.ApplicationBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public void list(ApplicationPageRequestDTO applicationPageRequestDTO, Model model) {
        log.info("Listing application");
        model.addAttribute("result",applicationBoardService.getList(applicationPageRequestDTO));
    }

    @GetMapping(value = "/mypagelist")
    public void mypagelist( long id, ApplicationPageRequestDTO applicationPageRequestDTO, Model model) {
        log.info("Listing application");
        log.info("id: " + id);

        model.addAttribute("mypageResult",applicationBoardService.getMypageList(applicationPageRequestDTO,id));
    }


    @GetMapping({"/read", "/modify"})
    public void read(long boardNo, @ModelAttribute("requestDTO") ApplicationPageRequestDTO requestDTO, Model model ){

        log.info("boardNo: " + boardNo);

        ApplicationBoardDTO dto = applicationBoardService.read(boardNo);
        ApplicationPageResultDTO<ApplicationBoardDTO, Object[]> result = applicationBoardService.getList(requestDTO);

        model.addAttribute("dto", dto);
        model.addAttribute("result", result);

    }

    @PostMapping("/remove")
    public String remove(long boardNo, RedirectAttributes redirectAttributes){


        log.info("boardNo: " + boardNo);
        applicationBoardService.remove(boardNo);

        redirectAttributes.addFlashAttribute("msg", boardNo);

        return "redirect:/applicationboard/list";

    }

    @PostMapping("/modify")
    public String modify(ApplicationBoardDTO dto,
                         @ModelAttribute("requestDTO") ApplicationPageRequestDTO requestDTO,
                         RedirectAttributes redirectAttributes){


        log.info("post modify.........................................");
        log.info("dto: " + dto);

        applicationBoardService.modify(dto);

        redirectAttributes.addAttribute("page",requestDTO.getPage());
        redirectAttributes.addAttribute("type",requestDTO.getType());
        redirectAttributes.addAttribute("keyword",requestDTO.getKeyword());

        redirectAttributes.addAttribute("boardNo",dto.getBoardNo());


        return "redirect:/applicationboard/read";

    }


}