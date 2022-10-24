package com.inf.khproject.controller;

import com.inf.khproject.dto.QNADTO;
import com.inf.khproject.dto.QNAReplyDTO;
import com.inf.khproject.service.QNAReplyService;
import com.inf.khproject.service.QNAService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qna/replies/")
@Log4j2
@RequiredArgsConstructor
public class QNAReplyController {

    private final QNAReplyService qnaReplyService;

    private final QNAService qnaService;

    @GetMapping(value = "/qna/{qnaNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QNAReplyDTO>> getListByQNA(@PathVariable("qnaNo") Long qnaNo) {

        log.info("qnaNo: " + qnaNo);

        return new ResponseEntity<>(qnaReplyService.getList(qnaNo), HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody QNAReplyDTO qnaReplyDTO) {

        log.info(qnaReplyDTO);

        QNADTO qnaDTO = qnaService.get(qnaReplyDTO.getQnaNo());
        qnaService.modifyStatusComplete(qnaDTO);

        Long qnaReplyNo = qnaReplyService.register(qnaReplyDTO);

        return new ResponseEntity<>(qnaReplyNo, HttpStatus.OK);

    }

    @DeleteMapping("/{qnaReplyNo}")
    public ResponseEntity<String> remove(@PathVariable("qnaReplyNo") Long qnaReplyNo) {

        QNADTO qnaDTO = qnaService.getByQnaReplyNo(qnaReplyNo);
        qnaService.modifyStatusWait(qnaDTO);

        qnaReplyService.remove(qnaReplyNo);

        return new ResponseEntity<>("success", HttpStatus.OK);

    }

    @PutMapping("/{qnaReplyNo}")
    public ResponseEntity<String> modify(@RequestBody QNAReplyDTO qnaReplyDTO) {

        log.info("qnaReplyDTO: " + qnaReplyDTO);

        qnaReplyService.modify(qnaReplyDTO);

        return new ResponseEntity<>("success", HttpStatus.OK);

    }

}
