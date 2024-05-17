package com.yedam.service;

import java.util.List;

import com.yedam.VO.CartVO;
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
	
	//cart관련
	//목록
	List<CartVO> cartList();
	//수정
	boolean modifyCart(CartVO cvo);
	//삭제
	boolean removeCart(int no);
}
