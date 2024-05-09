package com.yedam.common;

import java.util.List;

import com.yedam.VO.BoardVO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class BoardTest {
	public static void main(String[] args) {
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = svc.getBoard(1);
		if(vo != null) {
		System.out.println(vo.toString());
		}else {
			System.out.println("조회결과 없음");
		}
	}
}
