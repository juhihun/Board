package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.VO.BoardVO;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//title, content, writer 파라미터 boardVO에 담아서 db넘기기
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		
		if(svc.addBoard(vo)){
			System.out.println("등록성공");
			resp.sendRedirect("main.do");
		}else {
			System.out.println("등록실패");
		}
	
		List<BoardVO> list = svc.boardList();
		for(BoardVO board : list) {
			System.out.println(board.toString());
		}
	

	}

}
