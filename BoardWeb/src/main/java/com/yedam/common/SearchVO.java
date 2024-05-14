package com.yedam.common;

import lombok.Data;

@Data
public class SearchVO {

	private int page;
	private String searchCondition;
	private String keyword;
	
	
	//댓글목록관련
	private int boardNo;
	private int rpage;
}
