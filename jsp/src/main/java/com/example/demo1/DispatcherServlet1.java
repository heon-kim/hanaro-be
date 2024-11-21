package com.example.demo1;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/dispatcher1")
public class DispatcherServlet1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<h3>Dispatcher Test1 수행 결과</h3>");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/dispatcher2");
        rd.forward(request, response);
        out.close();

    }

    public void destroy() {
    }
}