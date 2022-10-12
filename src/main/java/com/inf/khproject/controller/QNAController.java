package com.inf.khproject.controller;

import ch.qos.logback.core.pattern.color.RedCompositeConverter;
import com.inf.khproject.dto.NoticeDTO;
import com.inf.khproject.dto.PageRequestDTO;
import com.inf.khproject.dto.QNADTO;
import com.inf.khproject.service.QNAService;
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
@RequestMapping("/service-center/qna")
@Log4j2
@RequiredArgsConstructor
public class QNAController {

    private final QNAService qnaService;

    @GetMapping("/")
    public String index() {

        return "redirect:/service-center/qna/list";

    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {

        log.info("list......" + pageRequestDTO);

        model.addAttribute("result", qnaService.getList(pageRequestDTO));

    }

    @GetMapping("/register")
    public void register() {
        log.info("register get...");
    }

    @PostMapping("/register")
    public String registerPost(QNADTO dto, RedirectAttributes redirectAttributes) {

        log.info("dto..." + dto);

        Long qnaNo = qnaService.register(dto);

        log.info("qnaNo: " + qnaNo);

        redirectAttributes.addFlashAttribute("msg", qnaNo);

        return "redirect:/service-center/qna/list";

    }

    @GetMapping({"/read", "/modify"})
    public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long qnaNo, Model model) {

        log.info("qnaNo: " + qnaNo);

        QNADTO qnaDTO = qnaService.get(qnaNo);

        log.info(qnaDTO);

        model.addAttribute("dto", qnaDTO);
        model.addAttribute("result", qnaService.getList(pageRequestDTO));

    }

    @PostMapping("/modify")
    public String modify(QNADTO qnaDTO, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, RedirectAttributes redirectAttributes) {

        log.info("post modify......");
        log.info("dto: " + qnaDTO);

        qnaService.modify(qnaDTO);

        redirectAttributes.addAttribute("page", requestDTO.getPage());
        redirectAttributes.addAttribute("qnaNo", qnaDTO.getQnaNo());

        return "redirect:/service-center/qna/read";

    }

    @PostMapping("/remove")
    public String remove(long qnaNo, RedirectAttributes redirectAttributes) {

        log.info("qnaNo: " + qnaNo);

        qnaService.removeWithReplies(qnaNo);

        redirectAttributes.addFlashAttribute("msg", qnaNo);

        return "redirect:/service-center/qna/list";

    }

}
