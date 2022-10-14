package com.inf.khproject.service;

import com.inf.khproject.dto.ApplicationBoardReplyDTO;
import com.inf.khproject.entity.ApplicationBoard;
import com.inf.khproject.entity.ApplicationBoardReply;
import com.inf.khproject.repository.ApplicationBoardReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationBoardReplyServiceImpl implements ApplicationBoardReplyService {

    private final ApplicationBoardReplyRepository applicationBoardReplyRepository;

    @Override
    public Long register(ApplicationBoardReplyDTO applicationBoardReplyDTO) {

        ApplicationBoardReply reply = dtoToEntity(applicationBoardReplyDTO);

        applicationBoardReplyRepository.save(reply);

        return reply.getRno();
    }

    @Override
    public List<ApplicationBoardReplyDTO> getList(Long boardNo) {

        List<ApplicationBoardReply> result =  applicationBoardReplyRepository
                .getRepliesByApplicationBoardOrderByRno(ApplicationBoard.builder().boardNo(boardNo).build());

        return result.stream().map(reply -> entityToDTO(reply)).collect(Collectors.toList());
    }

    @Override
    public void modify(ApplicationBoardReplyDTO replyDTO) {

        ApplicationBoardReply reply = dtoToEntity(replyDTO);

        applicationBoardReplyRepository.save(reply);

    }

    @Override
    public void remove(Long rno) {

        applicationBoardReplyRepository.deleteById(rno);
    }
}
