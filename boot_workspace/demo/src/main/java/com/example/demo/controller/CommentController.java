package com.example.demo.controller;

import com.example.demo.domain.CommentVO;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/comment")
@RestController
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/post")
    @ResponseBody
    public String post(@RequestBody CommentVO commentVO){
        log.info(">>>> commentVO >> {}", commentVO);
        int isOk = commentService.post(commentVO);
        return isOk >0 ? "1":"0";
    }

}

