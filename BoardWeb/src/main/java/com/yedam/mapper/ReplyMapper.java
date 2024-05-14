package com.yedam.mapper;

import java.util.List;

import com.yedam.VO.ReplyVO;
import com.yedam.common.SearchVO;

public interface ReplyMapper {
	
	//댓글목록
	List<ReplyVO> replyList(int boardNo);
	List<ReplyVO> replyListPaging(SearchVO search);
	//댓글삭제
	int deleteReply(int replyNo);
	//댓글등록
	int insertReply(ReplyVO vro);
	int replyCnt(int boardNo);
	//사용자id,pw확인
//	MEMBERVO SELECTMEMBER(@PARAM("ID") STRING ID, @PARAM("PW") STRING PW);
//	MemberVO selectMember2(String id);
	
	
	
}
