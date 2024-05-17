package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.VO.CartVO;
import com.yedam.VO.ReplyVO;
import com.yedam.common.DataSource;
import com.yedam.common.SearchVO;
import com.yedam.mapper.ReplyMapper;

public class ReplyServiceImpl implements ReplyService{

	SqlSession session = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = session.getMapper(ReplyMapper.class);
	
	@Override
	public List<ReplyVO> replyList(SearchVO search) {
		return mapper.replyListPaging(search);
	}

	@Override
	public boolean removeReply(int replyno) {
		return mapper.deleteReply(replyno) == 1;
	}

	@Override
	public boolean addReply(ReplyVO rvo) {
		return mapper.insertReply(rvo) == 1;
	}

	@Override
	public int getReplyCnt(int boardNo) {
		
		return mapper.replyCnt(boardNo);
	}

	@Override
	public boolean updateReply(ReplyVO rvo) {
		return mapper.updateReply(rvo) == 1;
	}

	@Override
	public List<CartVO> cartList() {
		return mapper.selectList();
	}

	@Override
	public boolean modifyCart(CartVO cvo) {
		return mapper.updateCart(cvo) == 1;
	}

	@Override
	public boolean removeCart(int no) {
		return mapper.deleteCart(no) == 1;
	}
	
	
	
}
