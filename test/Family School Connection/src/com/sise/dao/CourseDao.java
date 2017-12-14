package com.sise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sise.model.Course;
import com.sise.model.PageBean;
import com.sise.util.StringUtil;

public class CourseDao {

	public ResultSet courseList(Connection con,PageBean pageBean,Course course)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_course");
		if(course!=null&&StringUtil.isNotEmpty(course.getStuName())){
			sb.append(" and stuName like '%"+course.getStuName()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int courseCount(Connection con,Course course)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_course");
		if(StringUtil.isNotEmpty(course.getStuName())){
			sb.append(" and stuName like '%"+course.getStuName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and","where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	public int courseDelete(Connection con,String delIds)throws Exception{
		String sql="delete from t_course where couId in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	public int courseAdd(Connection con,Course course)throws Exception{
		String sql="insert into t_course value(null,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,course.getStuName());
		pstmt.setString(2,course.getCouCode());
		pstmt.setString(3,course.getCouName());
		pstmt.setDouble(4,course.getCouCredit());
		pstmt.setString(5,course.getCouScores());
		return pstmt.executeUpdate();
	}
	
	public int courseModify(Connection con,Course course)throws Exception{
		String sql="update t_course set stuName=?,couCode=?,couName=?,couCredit=?,couScores=? where couId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, course.getStuName());
		pstmt.setString(2, course.getCouCode());
		pstmt.setString(3, course.getCouName());
		pstmt.setDouble(4, course.getCouCredit());
		pstmt.setString(5, course.getCouScores());
		pstmt.setInt(6, course.getCouId());
		return pstmt.executeUpdate();
	}
}
