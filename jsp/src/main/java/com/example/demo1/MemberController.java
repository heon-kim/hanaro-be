package com.example.demo1;

import com.example.demo1.vo.MemberDAO;
import com.example.demo1.vo.Members;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@WebServlet("*.action")
public class MemberController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println("uri:"+uri);
        String contextPath = request.getContextPath();
        System.out.println("contextPath:"+contextPath);
        String cmd = uri.substring(contextPath.length());
        System.out.println("cmd:"+cmd);

        if(cmd.equals("/member/login.action")){
            System.out.println("login");
            System.out.println("=====================================");
            login(request,response);
        }else if(cmd.equals("/member/join.action")){
            System.out.println("join");
            System.out.println("=====================================");
            insert(request,response);
        }
        else if(cmd.equals("/member/list.action")){
            System.out.println("list");
            System.out.println("=====================================");
            list(request,response);
        }
        else if(cmd.equals("/member/read.action")){
            System.out.println("read");
            System.out.println("=====================================");
            getMember(request,response);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ServletContext application = request.getServletContext();
        MemberDAO dao = new MemberDAO(application);
        List<Members> mList = dao.getList();
        dao.close();
        request.setAttribute("mList", mList);
        request.getRequestDispatcher("/member/memberList.jsp").forward(request,response);
    }

    private void getMember(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        System.out.println("read action!");
        ServletContext application = request.getServletContext();
        MemberDAO dao = new MemberDAO(application);
        Members member = dao.getMember(request.getParameter("userId"));
        dao.close();
        request.setAttribute("member", member);
        System.out.println("member"+member);
        request.getRequestDispatcher("/member/read.jsp").forward(request,response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ServletContext application = request.getServletContext();
        Members member= new Members();
        MemberDAO dao = new MemberDAO(application);
        member.setUserId(request.getParameter("userId"));
        member.setUserName(request.getParameter("userName"));
        member.setEmail(request.getParameter("email"));
        member.setUserPwd(request.getParameter("userPwd"));
        dao.insert(member);
        request.getRequestDispatcher("/member/list.action").forward(request,response);

        dao.close();
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login action!");

        ServletContext application = request.getServletContext();
        MemberDAO dao = new MemberDAO(application);
        String userId = request.getParameter("userId");
        String userPwd = request.getParameter("userPwd");
        Members member = dao.getMember(userId);
        HttpSession session = request.getSession();
        boolean loggedIn = false;

        if (member != null) {
            System.out.println("pwd"+member.getUserPwd());
            if (member.getUserPwd().equals(userPwd)) {
                loggedIn = true;
                session.setAttribute("loginId", userId);
            }else{
                System.out.println("pwd err");
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>alert('비밀번호를 확인해주세요.'); history.go(-1);</script>");
                out.flush();
                response.flushBuffer();
                out.close();
            }
        }
        dao.close();
        if (loggedIn) {
            System.out.println("loggedIn" + loggedIn);
            System.out.println(session.getAttribute("loginId"));
            response.sendRedirect(request.getContextPath() + "/member/list.action");
        } else {
            request.getRequestDispatcher("/member/loginFrm.jsp").forward(request, response);
        }
    }

}
