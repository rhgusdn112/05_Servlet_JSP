package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

	//"/signup" POST 방식 요청을 처리하는 오버라이딩
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	/* 별도 처리 없이 바로 JSP로 요청 위임(떠넘기기) */
		
	// 1) 요청 위임할 JSP 경로 작성
	// 	-> webapp 폴더를 "/"(최상위 폴더)라 생각하고 작성하기
		String path = "/WEB-INF/views/signup_result.jsp";
	// 2) 요청을 위임시켜줄 객체 얻어오기
	//  + 어디로 위임할 지 매개 변수에 작성
	// 	-> RequestDispatcher(요청 발송자)
		RequestDispatcher dispatcher
		= req.getRequestDispatcher(path);
		
	
	// 3) HttpServletRequest/Response 두 객체를
	// 	  요청 위임(forward) 할 JSP에서 넘기기
	
	dispatcher.forward(req, resp);
	// forward  : 위임하다, 넘기다

	// request(req)  : 입력된 id, pw, 이름 등등..
	// response(resp) : 응답 받을 클라이언트와 연결되어있는 스트림 
	
	}
}
