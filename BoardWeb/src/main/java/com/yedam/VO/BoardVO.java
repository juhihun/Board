package com.yedam.VO;

import java.util.Date;

import lombok.Data;
@Data
public class BoardVO {

	private int boardNo; //board_no
	private String title;
	private String content;
	private String writer;
	private Date createDate;
	private int viewCnt;
	private String img;
}
