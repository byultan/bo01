package org.zerock.bo01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.bo01.domain.Board;
import org.zerock.bo01.repository.search.BoardSearch;

// Board에서 primary key가 되는값을 기입
public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
    @Query(value = "select nonw()", nativeQuery = true)
    String getTime();
}