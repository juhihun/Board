package com.yedam.service;

import java.util.List;

import com.yedam.VO.ReplyVO;
import com.yedam.common.SearchVO;

public interface ReplyService {
	//목록
	List<ReplyVO> replyList(SearchVO search);
	boolean removeReply(int replyno);
	boolean addReply(ReplyVO rvo);
	int getReplyCnt(int boardNo); //댓글갯수
	//로그인MemberVO login(String id, String pw);
//	
//	MemberVO checkMember(String id);
	boolean updateReply(ReplyVO rvo);
}
