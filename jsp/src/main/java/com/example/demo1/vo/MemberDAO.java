package com.example.demo1.vo;

import jakarta.servlet.ServletContext;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends JDBConnect {
    public MemberDAO(ServletContext application) {
        super(application);
    }

    public List<Members> getList() {
        List<Members> list = new ArrayList<Members>();
        String sql = "SELECT * FROM MEMBERS";
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public Members getMember(String userId) {
        Members member = null;
        String sql = "SELECT * FROM MEMBERS WHERE userId = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                member = new Members();
                member.setUserId(rs.getString("userId"));
                member.setUserPwd(rs.getString("userPwd"));
                member.setUserName(rs.getString("userName"));
                member.setPhoneNo(rs.getString("phoneNo"));
                member.setAddress(rs.getString("address"));
                member.setEmail(rs.getString("email"));
                member.setRegDate(rs.getString("regDate"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return member;
    }

    public int insert(Members member) {
        int result = 0; // 삽입된 행의 개수를 저장할 변수
        String sql = "INSERT INTO MEMBERS (userId, userPwd, userName, phoneNo, address, email) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(sql); // PreparedStatement 생성
            pstmt.setString(1, member.getUserId());
            pstmt.setString(2, member.getUserPwd());
            pstmt.setString(3, member.getUserName());
            pstmt.setString(4, member.getPhoneNo());
            pstmt.setString(5, member.getAddress());
            pstmt.setString(6, member.getEmail());

            result = pstmt.executeUpdate(); // INSERT 실행 및 삽입된 행의 개수를 반환
        } catch (Exception e) {
            System.out.println("Insert 오류: " + e.getMessage()); // 예외 처리
        }
        return result; // 삽입된 행의 개수 반환
    }

}
