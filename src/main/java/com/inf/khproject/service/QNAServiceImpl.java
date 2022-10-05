package com.inf.khproject.service;

import com.inf.khproject.dto.PageRequestDTO;
import com.inf.khproject.dto.PageResultDTO;
import com.inf.khproject.dto.QNADTO;
import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.QNA;
import com.inf.khproject.repository.QNAReplyRepository;
import com.inf.khproject.repository.QNARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class QNAServiceImpl implements QNAService {

    private final QNARepository qnaRepository;
    private final QNAReplyRepository qnaReplyRepository;

    @Override
    public Long register(QNADTO dto) {

        log.info(dto);

        QNA qna = dtoToEntity(dto);

        qnaRepository.save(qna);

        return qna.getQnaNo();

    }

    @Override
    public PageResultDTO<QNADTO, Object[]> getList(PageRequestDTO pageRequestDTO) {

        log.info(pageRequestDTO);

        Function<Object[], QNADTO> fn = (en -> entityToDTO((QNA) en[0], (Member) en[1]));

        Page<Object[]> result = qnaRepository.getQNAWithReply2(pageRequestDTO.getPageable(Sort.by("qnaNo").descending()));

        return new PageResultDTO<>(result, fn);

    }

    @Override
    public QNADTO get(Long qnaNo) {

        Object result = qnaRepository.getQNAByQnaNo(qnaNo);

        Object[] arr = (Object[]) result;

        return entityToDTO((QNA) arr[0], (Member) arr[1]);

    }

    @Transactional
    @Override
    public void removeWithReplies(Long qnaNo) {

        qnaReplyRepository.deleteByQnaNo(qnaNo);

        qnaRepository.deleteById(qnaNo);

    }

    @Transactional
    @Override
    public void modify(QNADTO qnaDTO) {

        QNA qna = qnaRepository.getOne(qnaDTO.getQnaNo());

        qna.changeTitle(qnaDTO.getTitle());
        qna.changeContent(qnaDTO.getContent());

        qnaRepository.save(qna);

    }

}
