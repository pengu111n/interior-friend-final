package com.inf.khproject.controller;

import com.inf.khproject.dto.ApplicationBoardChatDTO;
import com.inf.khproject.service.ApplicationBoardChatService;
import com.inf.khproject.service.ApplicationBoardChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicationboard/chat/")
@Log4j2
@RequiredArgsConstructor
public class ApplicationBoardChatController {

    private final ApplicationBoardChatService applicationBoardChatService;

    @GetMapping(value = "/applicationboard/{boardNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ApplicationBoardChatDTO>> getListByBoard(@PathVariable("boardNo") Long boardNo ){

        log.info("boardNo: " + boardNo);

        return new ResponseEntity<>( applicationBoardChatService.getList(boardNo), HttpStatus.OK);

    }


    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody ApplicationBoardChatDTO chatDTO){

        log.info(chatDTO);

        Long cno = applicationBoardChatService.register(chatDTO);

        return new ResponseEntity<>(cno, HttpStatus.OK);
    }

}
