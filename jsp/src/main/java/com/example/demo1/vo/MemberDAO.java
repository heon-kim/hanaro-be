package com.example.demo1.vo;

import jakarta.servlet.ServletContext;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends JDBConnect{
    public MemberDAO(ServletContext application){
        super(application);
    }

    public List<Members> getList(){
        List<Members> list = new ArrayList<Members>();
        String sql = "SELECT * FROM MEMBERS";
        try{
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Members member = new Members();
                member.setUserId(rs.getString("userId"));
                member.setUserPwd(rs.getString("userPwd"));
                member.setUserName(rs.getString("userName"));
                member.setPhoneNo(rs.getString("phoneNo"));
                member.setAddress(rs.getString("address"));
                member.setEmail(rs.getString("email"));
                member.setRegDate(rs.getString("regDate"));
                list.add(member);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
}
