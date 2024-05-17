package org.zerock.bo01.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.bo01.domain.Board;
import org.zerock.bo01.domain.QBoard;

import java.util.List;
/*
    JPA = db연결하려고 쓰는데 = mapping 을 위해서 사용함,
    build.gradle에 implemencies 추가하면 Qboard가 생기는데 이친구를 쉽게 사용하기위해서
    QuerydslRepositorySupport 클레스를 사용한다. 이 클레스를 무조건 사용해야하는데 다른클래스들과 같이 다중상속은 안되니까
    다른것들은 interface에서 사용한다.
*/
public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {
    public BoardSearchImpl(){
        super(Board.class); //부모인 QuerydslRepositorySupport에 갈때 Board.class타입이 간다.
    }
    @Override
    public Page<Board> search1(Pageable pageable) {
        QBoard board = QBoard.board;    //Qboard는 처음생성시 null
        JPQLQuery<Board> query = from(board);   //select * from board
        query.where(board.title.contains("3")); //board title이 3인걸 찾는다
        this.getQuerydsl().applyPagination(pageable, query);
//      this는 boardSearchImpl
        List<Board> list = query.fetch();   //fetch가 실행시킨다  list 결과값으로 돌려준다
        long count = query.fetchCount();    //실행한 query count값을 return

//      페이징을 위한 page객체
        return new PageImpl<>(list, pageable, count);
//      return null;
    }

    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable){
        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);

        if((types != null && types.length>0) && keyword != null){
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            for (String type : types){
                switch (type){

                    case "t":
                        booleanBuilder.or(board.title.contains(keyword));
                    //  해당 title에 keyword가 포함이 되어있는지
                        break;
                    case "c":
                        booleanBuilder.or(board.content.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.writer.contains(keyword));
                        break;
                }
            }
            query.where(booleanBuilder);
        }
        query.where(board.bno.gt(0L));

        //paging
        this.getQuerydsl().applyPagination(pageable, query);
        List<Board> list = query.fetch();
        long count = query.fetchCount();

        return new PageImpl<>(list, pageable, count);
    }
}