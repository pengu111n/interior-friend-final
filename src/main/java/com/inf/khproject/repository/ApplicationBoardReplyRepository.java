package com.inf.khproject.repository;

import com.inf.khproject.entity.ApplicationBoard;
import com.inf.khproject.entity.ApplicationBoardReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationBoardReplyRepository extends JpaRepository<ApplicationBoardReply, Long> {

    @Modifying
    @Query("delete from ApplicationBoardReply r where r.applicationBoard.boardNo =:boardNo ")
    void deleteByBoardNo(Long boardNo);

    List<ApplicationBoardReply> getRepliesByApplicationBoardOrderByRno(ApplicationBoard applicationBoard);

}
