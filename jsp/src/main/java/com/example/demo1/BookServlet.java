package com.example.demo1;

import com.example.demo1.vo.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/book/bookForm.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Book book = new Book();
        book.setBookId(Integer.parseInt(request.getParameter("bookId")));
        book.setBookName(request.getParameter("bookName"));
        book.setPublisher(request.getParameter("publisher"));
        book.setPrice(Integer.parseInt(request.getParameter("price")));
        request.setAttribute("book", book);
        request.getRequestDispatcher("/book/bookResult.jsp").forward(request, response);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/madang?useSSL=false", "scott", "tiger");
            String sql = "insert into book values(?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, book.getBookId());
            pstmt.setString(2, book.getBookName());
            pstmt.setString(3, book.getPublisher());
            pstmt.setInt(4, book.getPrice());
            pstmt.executeUpdate();
            sql = "select * from book where bookId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, book.getBookId());
            ResultSet rs = pstmt.executeQuery();
            book = new Book();
            rs.next();
            book.setBookId(rs.getInt("bookId"));
            book.setBookName(rs.getString("bookName"));
            book.setPublisher(rs.getString("publisher"));
            book.setPrice(rs.getInt("price"));
            request.getRequestDispatcher("/book/bookResult.jsp").forward(request, response);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
          // request.getRequestDispatcher("/book/bookResult.jsp").forward(request, response);
    }
}