package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.VO.ReplyVO;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class UpdateControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		String reply = req.getParameter("reply");
		String bno = req.getParameter("bno");
		String replyNo = req.getParameter("replyNo");
		
		Map<String, Object> result = new HashMap<>(); 
		ReplyVO vo = new ReplyVO();
		
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setReply(reply);
		vo.setReplyNo(Integer.parseInt(replyNo));

		ReplyService svc = new ReplyServiceImpl();
		if(svc.updateReply(vo)) {
			result.put("retCode", "OK");
		}else {
			result.put("retCode", "NG");
		}
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(result);
		
		resp.getWriter().print(json);
	}

}
