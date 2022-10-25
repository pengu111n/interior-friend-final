package com.inf.khproject.repository;

import com.inf.khproject.entity.QNA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QNARepository extends JpaRepository<QNA, Long> {

    @Query("select q, w from QNA q left join q.writer w where q.qnaNo =:qnaNo")
    Object getQnaWithWriter(@Param("qnaNo") Long qnaNo);

    @Query("select q, r from QNA q left join QNAReply r on r.qna = q where q.qnaNo =:qnaNo")
    List<Object[]> getQNAWithReply(@Param("qnaNo") Long qnaNo);

    @Query(value = "select q, w from QNA q left join q.writer w left join QNAReply r on r.qna = q group by q having w.id =:id")
    Page<Object[]> getQNAWithReply2(Pageable pageable, Long id);

    @Query(value = "select q, w from QNA q left join q.writer w left join QNAReply r on r.qna = q group by q")
    Page<Object[]> getQNAWithReply3(Pageable pageable);

    @Query("select q, w from QNA q left join q.writer w left outer join QNAReply r on r.qna = q where q.qnaNo =:qnaNo")
    Object getQNAByQnaNo(@Param("qnaNo") Long qnaNo);

    @Query("select count(q.qnaNo) from QNA q where q.writer.id =:id")
    int getQNACount(Long id);

    @Query("select count(q.qnaNo) from QNA q")
    int getAllQNACount(Long id);

}
