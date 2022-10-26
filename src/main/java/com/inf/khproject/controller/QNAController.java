package com.inf.khproject.controller;

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
@RequestMapping("/servicecenter/qna")
@Log4j2
@RequiredArgsConstructor
public class QNAController {

    private final QNAService qnaService;

    @GetMapping("/list")
    public void list(Long id, PageRequestDTO pageRequestDTO, Model model) {

        log.info("list......" + pageRequestDTO);
        log.info("count......" + qnaService.getCount(id));

        model.addAttribute("count", qnaService.getCount(id));
        model.addAttribute("result", qnaService.getList(pageRequestDTO, id));

    }

    @GetMapping("/listAll")
    public void listAll(Long id, PageRequestDTO pageRequestDTO, Model model) {
        model.addAttribute("count", qnaService.getAllCount(id));
        model.addAttribute("result", qnaService.getListAll(pageRequestDTO));
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

        return "redirect:/servicecenter/qna/list?id="+dto.getWriterMemNo();

    }

    @GetMapping({"/read", "/modify"})
    public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long qnaNo, Long id, Model model) {

        log.info("qnaNo: " + qnaNo);

        QNADTO qnaDTO = qnaService.get(qnaNo);

        log.info(qnaDTO);

        model.addAttribute("dto", qnaDTO);
        model.addAttribute("result", qnaService.getList(pageRequestDTO, id));

    }

    @PostMapping("/modify")
    public String modify(QNADTO qnaDTO, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, RedirectAttributes redirectAttributes) {

        log.info("post modify......");
        log.info("dto: " + qnaDTO);

        qnaService.modify(qnaDTO);

        redirectAttributes.addAttribute("page", requestDTO.getPage());
        redirectAttributes.addAttribute("qnaNo", qnaDTO.getQnaNo());

        return "redirect:/servicecenter/qna/read";

    }

    @PostMapping("/remove")
    public String remove(long qnaNo, RedirectAttributes redirectAttributes) {

        log.info("qnaNo: " + qnaNo);

        QNADTO dto = qnaService.get(qnaNo);

        qnaService.removeWithReplies(qnaNo);

        redirectAttributes.addFlashAttribute("msg", qnaNo);

        return "redirect:/servicecenter/qna/list?id="+dto.getWriterMemNo();

    }

}
