package com.example.bootJPA.service;

import com.example.bootJPA.dto.BoardDTO;
import com.example.bootJPA.dto.BoardFileDTO;
import com.example.bootJPA.dto.FileDTO;
import com.example.bootJPA.entity.Board;
import com.example.bootJPA.entity.File;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BoardService {

    // 추상 메서드만 가능한 인터페이스
    // 메서드가 default(접근제어자) 구현 가능.
    Long insert(BoardFileDTO boardFileDTO);

    /* BoardDTO => Board 객체로 변환
     * BoardDTO(class) : bno, title, writer, content, regDate, modDate
     * Board(table) : bno, title, writer, content
     * 화면에서 가져온 BoardDTO 객체를 저장을 위한 Board 테이블 객체로 변환
     *  */
    default Board convertDtoToEntity(BoardDTO boardDTO){
        return Board.builder()
                .bno(boardDTO.getBno())
                .title(boardDTO.getTitle())
                .writer(boardDTO.getWriter())
                .content(boardDTO.getContent())
                .build();
    }

    /* Board => BoardDTO 객체로 변환
     * 반대로 Board 테이블에서 가져온 객체를 BoardDTO 화면에 뿌리기위한 객체로 변환
     * */
    default BoardDTO convertEntityToDto(Board board){
        return BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .writer(board.getWriter())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .build();
    }

    // File 객체 <-> FileEntity convert
    // FileDTO -> File Entity
    default File convertDtoToEntity(FileDTO fileDTO){
        return File.builder()
                .uuid(fileDTO.getUuid())
                .saveDir(fileDTO.getSaveDir())
                .fileName(fileDTO.getFileName())
                .fileType(fileDTO.getFileType())
                .bno(fileDTO.getBno())
                .fileSize(fileDTO.getFileSize())
                .build();
    }

    // File Entity -> FileDTO
    default FileDTO convertEntityToDto(File file){
        return FileDTO.builder()
                .uuid(file.getUuid())
                .saveDir(file.getSaveDir())
                .fileName(file.getFileName())
                .fileType(file.getFileType())
                .bno(file.getBno())
                .fileSize(file.getFileSize())
                .regDate(file.getRegDate())
                .modDate(file.getModDate())
                .build();
    }


    List<BoardDTO> getList();

    Page<BoardDTO> getPageList(int pageNo);

    BoardFileDTO getDetail(Long bno);

    Long modify(BoardFileDTO boardFileDTO);

    void remove(Long bno);

    Page<BoardDTO> getList(int pageNo, String type, String keyword);

    long fileRemove(String uuid);
}