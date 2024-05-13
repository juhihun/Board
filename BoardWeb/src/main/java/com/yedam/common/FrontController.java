package com.yedam.common;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.web.AddBoardControl;
import com.yedam.web.AddFormControl;
import com.yedam.web.AddReplyControl;
import com.yedam.web.BoardInfoControl;
import com.yedam.web.LoginControl;
import com.yedam.web.LoginForm;
import com.yedam.web.LogoutControl;
import com.yedam.web.MainControl;
import com.yedam.web.ModBoardFormControl;
import com.yedam.web.ModifyControl;
import com.yedam.web.RemoveControl;
import com.yedam.web.RemoveFormControl;
import com.yedam.web.RemoveReplyControl;
import com.yedam.web.ReplyListControl;


public class FrontController extends HttpServlet {
	Map<String, Control> map;
	
	// 생성자
	public FrontController() {
		map = new HashMap<>();
	}

	// init
	@Override
	public void init() throws ServletException {
		//url패턴과 실행할  Control 구현클래스 정의
		map.put("/main.do", new MainControl());
		map.put("/addForm.do", new AddFormControl());
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/boardInfo.do",new BoardInfoControl());
		map.put("/modBoardForm.do", new ModBoardFormControl());
		map.put("/updateBoard.do", new ModifyControl());
		map.put("/delBoardForm.do", new RemoveFormControl());
		map.put("/deleteBoard.do", new RemoveControl());
		//로그인
		map.put("/logForm.do", new LoginForm());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		
		map.put("/replyList.do",new ReplyListControl());
		map.put("/removeReply.do",new RemoveReplyControl());
		map.put("/addReply.do",new AddReplyControl());
	}

	// service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8"); //요청정보의 한글처리

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		System.out.println("uri : " + uri + "  context : " + context);
		String path = uri.substring(context.length());
		System.out.println("path : " + path);
		
		Control control = map.get(path);
		control.exec(req,resp);
	}

	// destroy
	@Override
	public void destroy() {

	}
}
