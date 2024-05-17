package org.zerock.bo01.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.bo01.domain.Board;

public interface BoardSearch {
    Page<Board> search1(Pageable pageable); //interface사용하려면 구현해주어야한다.

    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);
}