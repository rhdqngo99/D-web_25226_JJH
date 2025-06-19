package com.example.demo.controller;

import com.example.demo.domain.BoardDTO;
import com.example.demo.domain.BoardVO;
import com.example.demo.domain.FileVO;
import com.example.demo.domain.PagingVO;
import com.example.demo.handler.FileHandler;
import com.example.demo.handler.FileRemoveHandler;
import com.example.demo.handler.PagingHandler;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/board/*")
@RequiredArgsConstructor
@Slf4j
@Controller
public class BoardController {
    private final BoardService boardService;
    private final FileHandler fileHandler;

    @GetMapping("/register")
    public void register(){}

    @PostMapping("/register")
    public String register(BoardVO boardVO,
                           @RequestParam(name="files", required = false)MultipartFile[] files){
        List<FileVO> fileList = null;
        if(files != null && files[0].getSize() > 0){
            fileList =fileHandler.uploadFiles(files);
            log.info(">>>> fileList >> {}",fileList);
        }
        boardService.register(new BoardDTO(boardVO,fileList));
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void list(Model model, PagingVO pagingVO){
        // 전체 게시글 수 가져오기
        int totalCount = boardService.getTotalCount(pagingVO); // 검색단어에 맞는 개수
        List<BoardVO> list = boardService.getList(pagingVO);
        PagingHandler pagingHandler = new PagingHandler(pagingVO, totalCount);
        model.addAttribute("list",list);
        model.addAttribute("ph", pagingHandler);
    }

    @GetMapping("/detail")
    public void detail(@RequestParam("bno") long bno, Model model){
        BoardDTO boardDTO = boardService.getDetail(bno);
        model.addAttribute("boardDTO", boardDTO);
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

    @ResponseBody
    @DeleteMapping("/file/{uuid}")
    public String fileRemove(@PathVariable("uuid") String uuid){
        FileVO fileVO = boardService.getFile(uuid);
        FileRemoveHandler fileRemoveHandler = new FileRemoveHandler();
        boolean isDel = fileRemoveHandler.deleteFile(fileVO);
        int isOk = boardService.fileDelete(uuid);
        return isOk > 0 && isDel ? "1" : "0";
    }

}
