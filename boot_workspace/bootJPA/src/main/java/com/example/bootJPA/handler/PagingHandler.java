package com.example.bootJPA.handler;

import com.example.bootJPA.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

@Getter
@Setter
@ToString
public class PagingHandler {
    private int startPage;
    private int endPage;
    private int totalPage;
    private boolean hasPrev, hasNext;
    private int pageNo;

    private String type;
    private String keyword;

    public PagingHandler(Page<BoardDTO> list, int pageNo, String type, String keyword){
        this.pageNo = pageNo;
        this.totalPage = list.getTotalPages();
        this.type = type;
        this.keyword = keyword;

        this.endPage = (int)Math.ceil(this.pageNo / 10.0) * 10;
        this.startPage = endPage - 9;

//        if(endPage > totalPage){
//            endPage = totalPage;
//        }

        this.endPage = (endPage > totalPage) ? totalPage : endPage;
        this.hasPrev = this.startPage > 10;
        this.hasNext = this.endPage < this.totalPage;
    }
}
