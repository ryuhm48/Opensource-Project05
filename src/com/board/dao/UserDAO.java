package com.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.login.beans.UserBean;
 
public class UserDAO {
//    싱글턴 적용하기
//    1.자기자신의 참조변수를 static으로 소유
//    2.생성자를 private으로 감춤
//    3.1에 대한 getter를 만들되 1이 null일 때 객체할당
 
//    1.
    private static UserDAO instance;
//    3.
    public static UserDAO getInstance(){
        if(instance == null)
            instance = new UserDAO();
        return instance;
    }
//    4.
    private Connection conn;
    private static String URL="jdbc:mysql://localhost:3306/BBS?characterEncoding=UTF-8&serverTimezone=UTC"; 
	private static String USERNAME="root";
    private static String PASSWORD="124";
//    2.
    private UserDAO(){
        try {     //5.생성자에서 커넥션 얻기
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//    모델 패키지에 있는 Member꺼 가져와서 쓰기
//    회원정보셋 데이터 추가하기
    public void insertMember(UserBean user)
    {
//        쿼리문 준비 처음엔 "" 상태로
        String sql = "insert into user values (?,?,?,?,?)";
        PreparedStatement pstmt = null;
//        conn객체에 미완성 쿼리문 준비된걸 던져서 구문객체 획득
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPwd());
            pstmt.setString(3, user.getGender());
            pstmt.setString(4, user.getName());
            pstmt.setString(5, user.getEmail());
//        구문객체날리기
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed())
                    pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public void updateMember(UserBean user)
    {
        String sql = "update user set pwd=?, name=?, email=? where userId=?";
        PreparedStatement pstmt = null;
 
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getPwd());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUserId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed())
                    pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
//    id에 해당하는 멤버 조회하기
    public UserBean selectOne(String userId)
    {
        String sql = "select * from member where userId = ?";
//        구문객체, 리턴할 객체, 결과셋 참조변수들 준비
        PreparedStatement pstmt = null;
        UserBean user = null;//리턴할 객체참조변수
        ResultSet rs = null;//결과셋 참조변수들 준비
        try {
//            구문객체획득
            pstmt = conn.prepareStatement(sql);
//            구문완성
            pstmt.setString(1, userId);
//            구문 날리고 result set 획득
            rs = pstmt.executeQuery();
//            Resultset 탐색
            if( rs.next() )
            {
                user = new UserBean();
                user.setUserId( rs.getString("userId"));
                user.setPwd(rs.getString("pwd"));
                user.setName( rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            try{
                if( pstmt != null && !pstmt.isClosed())
                    pstmt.close();
                if( rs != null && !rs.isClosed())
                    pstmt.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return user;
    }
    
//    member의 테이블정보 전체조회하기
    public List<UserBean> selectAll() {
        String sql = "select * from user";
        PreparedStatement pstmt = null;
//        결과값 탐색
        ResultSet rs = null;
        List<UserBean> userList = new ArrayList<UserBean>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while( rs.next() )
            {
                UserBean user = new UserBean();
                user.setUserId( rs.getString("userId") );
                user.setPwd(rs.getString("pwd"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                userList.add(user);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        구문객체와 Resultset객체 닫아주기
        finally{
            try{
                if( pstmt != null && !pstmt.isClosed())
                    pstmt.close();
                if( rs != null && !rs.isClosed())
                    pstmt.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return userList;
        
    }
}
