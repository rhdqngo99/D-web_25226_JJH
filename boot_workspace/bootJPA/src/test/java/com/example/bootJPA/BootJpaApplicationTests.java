package com.example.bootJPA;

import com.example.bootJPA.dto.BoardDTO;
import com.example.bootJPA.entity.Board;
import com.example.bootJPA.repository.BoardRepository;
import com.example.bootJPA.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootJpaApplicationTests {

	@Autowired
	private BoardService boardService;

	@Test
	void contextLoads() {
		for (int i = 1; i <= 300; i++) {
			BoardDTO boardDTO = BoardDTO.builder()
					.title("test Title" + (int)(Math.random()*100+1))
					.writer("tester"+(int)(Math.random()*100+1)+"@test.com")
					.content("test Content"+i)
					.build();
			boardService.insert(boardDTO);
		}
	}

}
