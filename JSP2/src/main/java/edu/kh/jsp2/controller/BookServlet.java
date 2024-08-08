package edu.kh.jsp2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp2.dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book/list")
public class BookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Book으로 타입이 제한된 List 생성
		List<Book> bookList = new ArrayList<Book>();

		// bookList에 샘플 데이터 추가
		bookList.add(new Book("자바 공부" , "백동현", 10000));
		bookList.add(new Book("HTML 공부" , "고현우", 20000));
		bookList.add(new Book("JS   공부" , "성상민", 15000));
		bookList.add(new Book("CSS  공부" , "정원근", 50000));
		bookList.add(new Book("서블릿이란", "강태환", 40000));
		bookList.add(new Book("JSP  란"	  ,	"강진형", 35000));
		bookList.add(new Book("Spring이란", "김대현", 700));

		// bookList를 요청 위임된 JSP에서도
		// 유지되어 사용 할 수 있도록
		// request scope객체에 속성으로 추가
		req.setAttribute("bookList", bookList);

		// JSP로 요청 위임
		String path = "/WEB-INF/views/book/bookList.jsp";

		req.getRequestDispatcher(path).forward(req, resp);
		
	}

}
