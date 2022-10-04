package com.inf.khproject.controller;

import com.inf.khproject.dto.NoticeDTO;
import com.inf.khproject.dto.PageRequestDTO;
import com.inf.khproject.service.NoticeService;
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
@RequestMapping("/service-center/notice")
@Log4j2
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/")
    public String index() {

        return "redirect:/service-center/notice/list";

    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {

        log.info("list......" + pageRequestDTO);

        model.addAttribute("result", noticeService.getList(pageRequestDTO));

    }

    @GetMapping("/register")
    public void register() {
        log.info("register......");
    }

    @PostMapping("/register")
    public String registerPost(NoticeDTO noticeDTO, RedirectAttributes redirectAttributes) {

        log.info("dto..." + noticeDTO);

        Long noticeNo = noticeService.register(noticeDTO);

        redirectAttributes.addFlashAttribute("msg", noticeNo);

        return "redirect:/service-center/notice/list";

    }

    @GetMapping({"/read", "/modify"})
    public void read(long noticeNo, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model) {

        log.info("noticeNo: " + noticeNo);

        NoticeDTO noticeDTO = noticeService.read(noticeNo);

        model.addAttribute("dto", noticeDTO);

    }

    @PostMapping("/modify")
    public String modify(NoticeDTO noticeDTO, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, RedirectAttributes redirectAttributes) {

        log.info("post modify......");
        log.info("dto: " + noticeDTO);

        noticeService.modify(noticeDTO);

        redirectAttributes.addAttribute("page", requestDTO.getPage());
        redirectAttributes.addAttribute("noticeNo", noticeDTO.getNoticeNo());

        return "redirect:/service-center/notice/read";

    }

    @PostMapping("/remove")
    public String remove(long noticeNo, RedirectAttributes redirectAttributes) {

        log.info("noticeNo: " + noticeNo);

        noticeService.remove(noticeNo);

        redirectAttributes.addFlashAttribute("msg", noticeNo);

        return "redirect:/service-center/notice/list";

    }

}
