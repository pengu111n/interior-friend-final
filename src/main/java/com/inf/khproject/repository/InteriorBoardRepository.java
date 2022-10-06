package com.inf.khproject.repository;

import com.inf.khproject.entity.InteriorBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InteriorBoardRepository extends JpaRepository<InteriorBoard, Long> {
    @Query("select m, ai from InteriorBoard m " +
            "left outer join InteriorBoardImage ai on ai.interiorBoard = m group by m ")
    Page<Object[]> getListPage(Pageable pageable);

    @Query("select m, mi " +
            " from InteriorBoard m left outer join InteriorBoardImage mi on mi.interiorBoard = m " +
            " where m.boardNo = :boardNo group by mi")
    List<Object[]> getInteriorBoardWithAll(Long boardNo);

}
