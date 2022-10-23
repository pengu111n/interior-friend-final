package com.inf.khproject.service;

import com.inf.khproject.dto.ApplicationBoardChatDTO;
import com.inf.khproject.entity.ApplicationBoard;
import com.inf.khproject.entity.ApplicationBoardChat;
import com.inf.khproject.repository.ApplicationBoardChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationBoardChatServiceImpl implements ApplicationBoardChatService {

    private final ApplicationBoardChatRepository applicationBoardChatRepository;

    @Override
    public Long register(ApplicationBoardChatDTO applicationBoardChatDTO) {

        ApplicationBoardChat chat = dtoToEntity(applicationBoardChatDTO);

        applicationBoardChatRepository.save(chat);

        return chat.getCno();
    }

    @Override
    public List<ApplicationBoardChatDTO> getList(Long boardNo) {

        List<ApplicationBoardChat> result =  applicationBoardChatRepository
                .getChatByApplicationBoardOrderByCno(ApplicationBoard.builder().boardNo(boardNo).build());

        return result.stream().map(chat -> entityToDTO(chat)).collect(Collectors.toList());
    }

}
