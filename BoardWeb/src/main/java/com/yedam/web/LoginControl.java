package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.yedam.VO.MemberVO;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//id,pw 파라미터
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		BoardService svc = new BoardServiceImpl();
		MemberVO mvo = svc.login(id, pw);
		
		if(mvo != null){
			HttpSession Session = req.getSession();
			Session.setAttribute("logId",mvo.getUserId());
			
			//관리자, 회원 구분
			if(mvo.getUserResp().equals("Admin")) {
				resp.sendRedirect("memberList.do");
			}else {
			resp.sendRedirect("main.do");
			}}else {
			resp.sendRedirect("logForm.do");
		}
	}

}
