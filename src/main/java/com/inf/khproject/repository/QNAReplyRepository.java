package com.inf.khproject.repository;

import com.inf.khproject.entity.QNAReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface QNAReplyRepository extends JpaRepository<QNAReply, Long> {

    @Modifying
    @Query("delete from QNAReply r where r.qna.qnaNo =:qnaNo")
    void deleteByQnaNo(Long qnaNo);

}
