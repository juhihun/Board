package com.yedam.common;

import org.apache.ibatis.session.SqlSession;

import com.yedam.VO.CartVO;
import com.yedam.mapper.ReplyMapper;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class BoardTest {
	public static void main(String[] args) {
		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		
//		BoardService svc = new BoardServiceImpl();
		//svc.boardList(1).forEach(board -> System.out.println(board));
		
//		SearchVO search = new SearchVO();
//		search.setSearchCondition("TW");
//		search.setKeyword("제목");
//		search.setBoardNo(645);
//		search.setRpage(2);
		
		CartVO cvo = new CartVO();
		cvo.setNo(3);
		cvo.setQty(1);
		int r = mapper.updateCart(cvo);
		System.out.println("건수 : " + r);
		

//		mapper.boardListPaging(search).forEach(board -> System.out.println(board));
//		mapper.replyListPaging(search).forEach(reply -> System.out.println(reply));
		mapper.selectList().forEach(cart -> System.out.println(cart));
		
	}
}