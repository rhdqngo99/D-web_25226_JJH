package com.berry.project.controller;

import com.berry.project.dto.CustomerIqBoardDTO;
import com.berry.project.service.CustomerIqBoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qna")
public class CustomerIqBoardController {

    private final CustomerIqBoardService service;

    public CustomerIqBoardController(CustomerIqBoardService service) {

        this.service = service;
    }

    // 게시글 등록
    @PostMapping
    public ResponseEntity<CustomerIqBoardDTO.Response> create(@RequestBody CustomerIqBoardDTO.Request request) {
        CustomerIqBoardDTO.Response response = service.create(request);
        return ResponseEntity.ok(response);
    }

    // 게시글 목록 조회
    @GetMapping
    public ResponseEntity<List<CustomerIqBoardDTO.Response>> list() {
        List<CustomerIqBoardDTO.Response> responses = service.list();
        return ResponseEntity.ok(responses);
    }

    // 게시글 상세 조회
    @GetMapping("/{bno}")
    public ResponseEntity<CustomerIqBoardDTO.Response> detail(@PathVariable Long bno) {
        CustomerIqBoardDTO.Response response = service.detail(bno);
        return ResponseEntity.ok(response);
    }

    // 게시글 수정
    @PutMapping("/{bno}")
    public ResponseEntity<CustomerIqBoardDTO.Response> update(@PathVariable Long bno,
                                                              @RequestBody CustomerIqBoardDTO.Request request) {
        CustomerIqBoardDTO.Response response = service.update(bno, request);
        return ResponseEntity.ok(response);
    }

    // 게시글 삭제
    @DeleteMapping("/{bno}")
    public ResponseEntity<String> delete(@PathVariable Long bno) {
        service.delete(bno);
        return ResponseEntity.ok("게시글이 삭제되었습니다.");
    }

    // 댓글(답글) 등록 및 수정
    @PutMapping("/{bno}/comment")
    public ResponseEntity<CustomerIqBoardDTO.Response> addOrUpdateComment(@PathVariable Long bno,
                                                                          @RequestBody String comment) {
        CustomerIqBoardDTO.Response response = service.addOrUpdateComment(bno, comment);
        return ResponseEntity.ok(response);
    }
}