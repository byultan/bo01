package org.zerock.bo01.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.bo01.dto.BoardDTO;
import org.zerock.bo01.dto.PageRequestDTO;
import org.zerock.bo01.dto.PageResponseDTO;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){
        BoardDTO boardDTO = BoardDTO.builder()
                        .title("boardDTO test...")
                        .content("boardDTO test...")
                        .writer("user00")
                        .build();
        Long bno = boardService.register(boardDTO);
        log.info("bno: "+bno);
    }

    @Test
    public void testModify(){
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(99L)
                .title("update..")
                .content("update..")
                .build();
        boardService.modify(boardDTO);
        log.info(boardDTO);
    }
    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcw")
                .keyword("3")
                .page(1)
                .size(10)
                .build();
        PageResponseDTO<BoardDTO> responseDTO =boardService.list(pageRequestDTO);
        log.info(responseDTO);
    }
}
