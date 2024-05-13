package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.VO.BoardVO;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class AddFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "WEB-INF/board/addBoard.jsp";
		path="board/addBoard.tiles";
		
//		req.getRequestDispatcher(path);
//		BoardService svc = new BoardServiceImpl();
//		List<BoardVO> list = svc.boardList(search);
		
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
		

	}

}
