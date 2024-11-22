package com.example.demo1.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "AnnoFilter", urlPatterns="/filters/AnnoFilter.jsp")
public class AnnoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        String searchField = request.getParameter("searchField");
        String searchWord = request.getParameter("searchWord");
        System.out.println("검색필드:"+searchField);
        System.out.println("검색어:"+searchWord);
        chain.doFilter(request, response);
    }
}
