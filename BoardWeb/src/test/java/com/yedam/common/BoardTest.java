package com.yedam.common;

import org.apache.ibatis.session.SqlSession;

import com.yedam.mapper.BoardMapper;
import com.yedam.mapper.ReplyMapper;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class BoardTest {
	public static void main(String[] args) {
		BoardService svc = new BoardServiceImpl();
		//svc.boardList(1).forEach(board -> System.out.println(board));
		
		SearchVO search = new SearchVO();
		search.setSearchCondition("TW");
		search.setKeyword("제목");
		search.setPage(1);
		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		

//		mapper.boardListPaging(search).forEach(board -> System.out.println(board));
		mapper.replyList(645).forEach(reply -> System.out.println(reply));
		
	}
}
