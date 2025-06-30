package com.example.demo.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PagingVO {
    private int pageNo; // 현재 페이지번호 (선택한 페이지네이션 번호)
    private int qty; // 한페이지에 출력되는 게시글 수

    private String type;
    private String keyword;

    public PagingVO(){
        // 페이징 값이 없이 들어오는 기본값.
        this.pageNo = 1;
        this.qty = 10;
    }
    public PagingVO(int pageNo, int qty){
        this.pageNo = pageNo;
        this.qty = qty;
    }
    public int getStartIndex(){
        return (this.pageNo - 1) * this.qty;
    }

    public String[] getTypeToArray(){
        return this.type == null ? new String[]{} : this.type.split("");
    }
}