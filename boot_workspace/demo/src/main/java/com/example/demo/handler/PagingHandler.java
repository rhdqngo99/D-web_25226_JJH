package com.example.demo.handler;

import com.example.demo.domain.PagingVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingHandler {
    private int startPage;
    private int endPage;
    private int readEndPage;
    private boolean prev, next;

    private int totalCount;
    private PagingVO pagingVO;

    public PagingHandler(PagingVO pagingVO, int totalCount){
        this.pagingVO = pagingVO;
        this.totalCount = totalCount;
        // 1~10  / 11~20 / 21~30 ...
        // (현재 페이지번호 / 10 ) 올림 => * 10
        this.endPage = (int)Math.ceil(pagingVO.getPageNo() / 10.0) * 10;
        this.startPage = endPage - 9;

        this.readEndPage = (int)Math.ceil(this.totalCount / (double)pagingVO.getQty());

        if(this.readEndPage < this.endPage){
            this.endPage = readEndPage;
        }

        this.prev = this.startPage > 1 ; // 1 11 21 31
        this.next = this.endPage < this.readEndPage;
    }
}
