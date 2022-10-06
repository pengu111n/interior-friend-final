package com.inf.khproject.repository;

import com.inf.khproject.entity.InteriorBoardImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface InteriorBoardImageRepository extends JpaRepository<InteriorBoardImage, Long> {

    @Modifying
    @Query("delete from InteriorBoardImage ai where ai.interiorBoard.boardNo = :boardNo")
    void deleteByApplicationBoard(long boardNo);
}
