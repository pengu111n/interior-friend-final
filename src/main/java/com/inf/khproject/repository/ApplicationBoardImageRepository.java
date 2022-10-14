package com.inf.khproject.repository;

import com.inf.khproject.entity.ApplicationBoardImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ApplicationBoardImageRepository extends JpaRepository<ApplicationBoardImage, Long> {

    @Modifying
    @Query("delete from ApplicationBoardImage ai where ai.applicationBoard.boardNo = :boardNo")
    void deleteByApplicationBoard(long boardNo);
}
