package com.example.demo1;

import com.example.demo1.vo.MemberDAO;
import com.example.demo1.vo.Members;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
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
        }else if(cmd.equals("/member/join.action")){
            System.out.println("join");
            System.out.println("=====================================");
        }
        else if(cmd.equals("/member/list.action")){
            System.out.println("list");
            System.out.println("=====================================");
            list(request,response);
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
}
