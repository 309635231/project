package com.sise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sise.model.User;

public class UserDao {
	
	public User login(Connection con,User user) throws SQLException{
		User resultUser=null;
		String sql="select * from t_user where username=? and password=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			resultUser=new User();
			resultUser.setUsername(rs.getString("username"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}
	

	 public void addUser(String username,String psw){  
	        Connection con =null;  
	        PreparedStatement pstmt =null;  
	        try {  
	            String driver ="com.mysql.jdbc.Driver";  
	            String url ="jdbc:mysql://localhost:3306/sakila";  
	            String user ="root";  
	            String password ="461651682";//改为自己的用户名密码和数据库名  
	            Class.forName(driver);  
	            con = DriverManager.getConnection(url, user, password);  
	            String sql = "INSERT INTO student VALUES(?,?)";  
	            pstmt = con.prepareStatement(sql);  
	            pstmt.setString(1, username);  
	            pstmt.setString(2, psw);  
	            pstmt.executeUpdate();  
	        } catch (ClassNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }finally {  
	            try {  
	                if(pstmt!=null)pstmt.close();  
	                if(con!=null)con.close();  
	                }   
	            catch (SQLException e) {          
	                                    }  
	        }  
	    }  
	
	
}
