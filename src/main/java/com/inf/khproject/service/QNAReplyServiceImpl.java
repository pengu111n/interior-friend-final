package com.inf.khproject.service;

import com.inf.khproject.dto.QNAReplyDTO;
import com.inf.khproject.entity.QNA;
import com.inf.khproject.entity.QNAReply;
import com.inf.khproject.repository.QNAReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QNAReplyServiceImpl implements QNAReplyService{

    private final QNAReplyRepository qnaReplyRepository;

    @Override
    public Long register(QNAReplyDTO qnaReplyDTO) {

        QNAReply qnaReply = dtoToEntity(qnaReplyDTO);

        qnaReplyRepository.save(qnaReply);

        return qnaReply.getQnaReplyNo();

    }

    @Override
    public List<QNAReplyDTO> getList(Long qnaNo) {

        List<QNAReply> result = qnaReplyRepository.getQNARepliesByQnaOrderByQnaReplyNo(QNA.builder().qnaNo(qnaNo).build());

        return result.stream().map(reply -> entityToDTO(reply)).collect(Collectors.toList());

    }

    @Override
    public void modify(QNAReplyDTO qnaReplyDTO) {

        QNAReply qnaReply = dtoToEntity(qnaReplyDTO);

        qnaReplyRepository.save(qnaReply);

    }

    @Override
    public void remove(Long qnaReplyNo) {

        qnaReplyRepository.deleteById(qnaReplyNo);

    }
}
