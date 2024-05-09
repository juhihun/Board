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

public class RemoveControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
	
		
		BoardVO vo = new BoardVO();
		
		vo.setBoardNo(Integer.parseInt(bno));
	
		BoardService svc = new BoardServiceImpl();
		if(svc.delBoard(vo)){
			System.out.println("삭제성공");
			resp.sendRedirect("main.do");
		}else {
			System.out.println("삭제실패");
		}
	
		List<BoardVO> list = svc.boardList();
		for(BoardVO board : list) {
			System.out.println(board.toString());
		}
		

	}

}
