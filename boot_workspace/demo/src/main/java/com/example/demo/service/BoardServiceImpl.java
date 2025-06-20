package com.example.demo.service;

import com.example.demo.domain.BoardDTO;
import com.example.demo.domain.BoardVO;
import com.example.demo.domain.FileVO;
import com.example.demo.domain.PagingVO;
import com.example.demo.repository.BoardMapper;
import com.example.demo.repository.FileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
    private final BoardMapper boardMapper;
    private final FileMapper fileMapper;

    @Transactional
    @Override
    public void register(BoardDTO boardDTO) {
        boardMapper.register(boardDTO.getBoardVO());
        // fileList 추후 fileMapper로 추가.
        if(boardDTO.getFileList() == null){
            return;
        }
        if(boardDTO.getFileList().size() > 0){
            // 파일 저장
            // 가장 최신의 bno 가져오기 => 가장 큰 bno
            long bno = boardMapper.getBno();
            for(FileVO fvo : boardDTO.getFileList()){
                fvo.setBno(bno);
                fileMapper.insertFile(fvo);
            }
        }

    }

    @Override
    public List<BoardVO> getList(PagingVO pagingVO) {
        return boardMapper.getList(pagingVO);
    }

    @Override
    public BoardDTO getDetail(long bno) {
        BoardDTO boardDTO = new BoardDTO(
                boardMapper.getDetail(bno), fileMapper.getList(bno));
        return boardDTO;
    }

    @Override
    public void delete(long bno) {
        boardMapper.delete(bno);
    }

    @Override
    public void update(BoardDTO boardDTO) {
        boardMapper.update(boardDTO.getBoardVO());
        if(boardDTO.getFileList() == null){
            return;
        }
        if(!boardDTO.getFileList().isEmpty()){
            for(FileVO fvo : boardDTO.getFileList()){
                fvo.setBno(boardDTO.getBoardVO().getBno());
                fileMapper.insertFile(fvo);
            }
        }
    }

    @Override
    public int getTotalCount(PagingVO pagingVO) {
        return boardMapper.getTotalCount(pagingVO);
    }

    @Override
    public int fileDelete(String uuid) {
        return fileMapper.fileRemove(uuid);
    }

    @Override
    public FileVO getFile(String uuid) {
        return fileMapper.getFile(uuid);
    }
}