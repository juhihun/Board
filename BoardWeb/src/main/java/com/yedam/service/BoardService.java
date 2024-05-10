package com.yedam.service;

import java.util.List;

import com.yedam.VO.BoardVO;
import com.yedam.VO.MemberVO;

public interface BoardService {
	
	List<BoardVO> boardList(int page);//목록
	int getTotal(); //전체건수

	boolean addBoard(BoardVO vo);
	BoardVO getBoard(int boardNo);
	int addViewCnt(int boardNo);
	//수정
	boolean modifyBoard(BoardVO board);
	//삭제
	boolean delBoard(BoardVO board);
	//로그인
	MemberVO login(String id, String pw);
	MemberVO checkMember(String id);
}
