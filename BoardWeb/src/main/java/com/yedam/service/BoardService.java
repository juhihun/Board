package com.yedam.service;

import java.util.List;

import com.yedam.VO.BoardVO;

public interface BoardService {
	
	List<BoardVO> boardList();

	boolean addBoard(BoardVO vo);
	BoardVO getBoard(int boardNo);
	int addViewCnt(int boardNo);
	//수정
	boolean modifyBoard(BoardVO board);
	
	boolean delBoard(BoardVO board);
}
