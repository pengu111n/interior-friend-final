package com.inf.khproject.repository;

import com.inf.khproject.entity.ApplicationBoard;
import com.inf.khproject.repository.search.SearchBoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ApplicationBoardRepository extends JpaRepository<ApplicationBoard, Long>, SearchBoardRepository {
    @Query("select m, ai from ApplicationBoard m " +
            "left outer join ApplicationBoardImage ai on ai.applicationBoard = m group by m ")
    Page<Object[]> getListPage(Pageable pageable);

    @Query("select m, mi " +
            " from ApplicationBoard m left outer join ApplicationBoardImage mi on mi.applicationBoard = m " +
            " where m.boardNo = :boardNo group by mi")
    List<Object[]> getApplicationboardWithAll(Long boardNo);


    @Query("update ApplicationBoard m set m.view_count = m.view_count + 1 where m.boardNo = :boardNo")
    @Modifying
    @Transactional
    void updateview_count(long boardNo);


}
