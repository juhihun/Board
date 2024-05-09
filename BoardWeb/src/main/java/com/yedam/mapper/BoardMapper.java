package com.yedam.mapper;

import java.util.List;

import com.yedam.VO.BoardVO;

public interface BoardMapper {

	List<BoardVO> boardList(); //전체목록가져오기
	int insertBoard(BoardVO board);
	BoardVO selectBoard(int boardNo);
	int updateViewCnt(int boardNo);
	int updateBoard(BoardVO board);  //수정처리
	int deleteBoard(BoardVO board);
}
