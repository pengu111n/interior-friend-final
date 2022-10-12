package com.inf.khproject.controller;

import com.inf.khproject.dto.ApplicationBoardReplyDTO;
import com.inf.khproject.service.ApplicationBoardReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/replies/")
@Log4j2
@RequiredArgsConstructor
public class ApplicationBoardReplyController {

    private final ApplicationBoardReplyService applicationBoardReplyService;

    @GetMapping(value = "/applicationboard/{boardNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ApplicationBoardReplyDTO>> getListByBoard(@PathVariable("boardNo") Long boardNo ){

        log.info("boardNo: " + boardNo);

        return new ResponseEntity<>( applicationBoardReplyService.getList(boardNo), HttpStatus.OK);

    }


    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody ApplicationBoardReplyDTO replyDTO){

        log.info(replyDTO);

        Long rno = applicationBoardReplyService.register(replyDTO);

        return new ResponseEntity<>(rno, HttpStatus.OK);
    }

    @DeleteMapping("/{rno}")
    public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {

        log.info("RNO:" + rno );

        applicationBoardReplyService.remove(rno);

        return new ResponseEntity<>("success", HttpStatus.OK);

    }

    @PutMapping("/{rno}")
    public ResponseEntity<String> modify(@RequestBody ApplicationBoardReplyDTO replyDTO) {

        log.info(replyDTO);

        applicationBoardReplyService.modify(replyDTO);

        return new ResponseEntity<>("success", HttpStatus.OK);

    }





}
