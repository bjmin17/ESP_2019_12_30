package com.biz.esp.domain;

import com.biz.esp.domain.TargetVO.TargetVOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PaginationDTO {
	
	
	private int pageSize = 10;		// 한 페이지당 게시글 수
	private int rangeSize = 5;		// 한 블럭(range)당 페이지 수
	private int curPage = 1;		// 현재 페이지
	private int curRange = 1;		// 현재 블럭
	private int listCnt; 			// 총 게시글 수
	private int pageCnt;			// 총 페이지 수
	private int rangeCnt;			// 총 블럭 수
	private int startPage = 1;		// 시작 페이지
	private int endPage = 1;		// 끝 페이지
	private int startIndex = 0;		// 시작 인덱스
	private int prevPage;			// 이전 페이지
	private int nextPage;			// 다음 페이지
	

	
	public PaginationDTO(int listCnt, int curPage) {
		// TODO Auto-generated constructor stub
		this.listCnt = listCnt;
		this.curPage = curPage;
	}
}
