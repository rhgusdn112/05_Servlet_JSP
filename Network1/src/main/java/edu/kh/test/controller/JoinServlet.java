package edu.kh.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.test.model.dto.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 회원 목록 초기화
        List<Member> memberList = new ArrayList<Member>();
        memberList.add(new Member("test01", "1234", "김테스트"));
        memberList.add(new Member("test02", "5678", "최테스트"));
        memberList.add(new Member("test03", "qwer", "박테스트"));

        // 사용자 입력값 가져오기
        String memberId = req.getParameter("memberId");
        String memberPw = req.getParameter("memberPw");
        String memberName = req.getParameter("memberName");

        // 회원 ID 중복 확인
        for (Member member : memberList) {
            if (member.getMemberId().equals(memberId)) {
                HttpSession session = req.getSession();
                session.setAttribute("message", memberId + "은/는 이미 존재하는 아이디 입니다.");
                resp.sendRedirect("/");
                return;
            }
        }

        // 중복되지 않은 경우, 새 회원 생성
        Member member = new Member(memberId, memberPw, memberName);
        memberList.add(member);

        // 성공 메시지 준비
        String message = String.format("%s/%s 님이 가입 되었습니다 (비밀번호 : %s)", memberId, memberName, memberPw);
        req.setAttribute("message", message);

        // 요청을 성공 페이지로 포워딩
        String path = "/WEB-INF/views/sucess.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
    }
}