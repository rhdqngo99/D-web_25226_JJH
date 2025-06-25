package com.example.bootJPA.controller;

import com.example.bootJPA.dto.CommentDTO;
import com.example.bootJPA.handler.PagingHandler;
import com.example.bootJPA.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/comment/*")
@RestController
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/post")
    @ResponseBody
    public String post(@RequestBody CommentDTO commentDTO){
        log.info(">>>> commentDTO >> {}", commentDTO);
        long cno = commentService.post(commentDTO);
        return cno > 0 ? "1" : "0";
    }

    @GetMapping("/list/{bno}/{page}")
    @ResponseBody
    public PagingHandler<CommentDTO> list(@PathVariable("bno") Long bno,
                                          @PathVariable("page") int page){
        // page = 0 부터
        Page<CommentDTO> list = commentService.getList(bno, page-1);
        PagingHandler<CommentDTO> ph = new PagingHandler<>(list, page);
        // page 없는 경우
        //List<CommentDTO> list = commentService.getList(bno);
        return ph;
    }

    @PutMapping("/modify")
    @ResponseBody
    public String modify(@RequestBody CommentDTO commentDTO){
        Long cno = commentService.modify(commentDTO);
        return cno > 0 ? "1" : "0";
    }

    @DeleteMapping("/remove/{cno}")
    @ResponseBody
    public String remove(@PathVariable("cno") long cno){
        Long isOk = commentService.remove(cno);
        return isOk != null ? "1" : "0";
    }
}
