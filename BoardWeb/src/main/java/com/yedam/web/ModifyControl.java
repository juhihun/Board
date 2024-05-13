package com.yedam.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.VO.BoardVO;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class ModifyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//bno, title, content 3개 파라미터 넘어옴
		//수정후목록으로 이동
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		BoardVO vo = new BoardVO();
		
	
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardService svc = new BoardServiceImpl();
		String encodekw = URLEncoder.encode(kw, "utf-8"); //한글 encoding 처리
		
		if(svc.modifyBoard(vo)){
			System.out.println("수정성공");
			resp.sendRedirect("main.do?page="+ page +"&searchCondition=" + sc + "&keyword" + encodekw);
		}else {
			System.out.println("수정실패");
		}
	
	
		
		
	}

}
