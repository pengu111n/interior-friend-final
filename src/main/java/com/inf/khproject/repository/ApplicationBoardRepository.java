package com.inf.khproject.repository;

import com.inf.khproject.entity.ApplicationBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationBoardRepository extends JpaRepository<ApplicationBoard, Long> {
    @Query("select m, ai from ApplicationBoard m " +
            "left outer join ApplicationBoardImage ai on ai.applicationBoard = m group by m ")
    Page<Object[]> getListPage(Pageable pageable);

    @Query("select m, mi " +
            " from ApplicationBoard m left outer join ApplicationBoardImage mi on mi.applicationBoard = m " +
            " where m.boardNo = :boardNo group by mi")
    List<Object[]> getApplicationboardWithAll(Long boardNo);



}
