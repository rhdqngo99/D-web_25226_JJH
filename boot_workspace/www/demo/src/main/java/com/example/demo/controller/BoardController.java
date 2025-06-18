package com.example.demo.controller;

import com.example.demo.domain.BoardVO;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/board/*")
@RequiredArgsConstructor
@Slf4j
@Controller
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/register")
    public void register(){}

    @PostMapping("/register")
    public String register(BoardVO boardVO){
        boardService.register(boardVO);
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void list(Model model){
        List<BoardVO> list = boardService.getList();
        model.addAttribute("list",list);
    }

    @GetMapping("/detail")
    public void detail(@RequestParam("bno") long bno, Model model){
        BoardVO bvo = boardService.getDetail(bno);
        model.addAttribute("bvo", bvo);
    }

    @PostMapping("/modify")
    public String update(BoardVO boardVO, RedirectAttributes redirectAttributes){
        boardService.update(boardVO);
        redirectAttributes.addAttribute("bno", boardVO.getBno());
        return "redirect:/board/detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bno") long bno){
        boardService.delete(bno);
        return "redirect:/board/list";
    }

}