package com.inf.khproject.repository.search;

import com.inf.khproject.entity.ApplicationBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchBoardRepository {

    ApplicationBoard search1();

    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);

}
