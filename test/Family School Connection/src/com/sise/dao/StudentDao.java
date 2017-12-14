package com.sise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement.ParseInfo;
import com.sise.model.PageBean;
import com.sise.model.Student;
import com.sise.util.DateUtil;
import com.sise.util.StringUtil;

public class StudentDao {
	
	public ResultSet studentList(Connection con,PageBean pageBean,Student student)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_student s1,t_grade g where s1.gradeId=g.id");
		if(StringUtil.isNotEmpty(student.getStuNo())){
			sb.append(" and s1.stuNo like '%"+student.getStuNo()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getStuName())){
			sb.append(" and s1.stuName like '%"+student.getStuName()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getSex())){
			sb.append(" and s1.sex like '%"+student.getSex()+"%'");
		}
		if(student.getGradeId()!=-1){
			sb.append(" and s1.gradeId like '%"+student.getGradeId()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getStuDesc())){
			sb.append(" and s1.stuDesc like '%"+student.getStuDesc()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getStuConsp())){
			sb.append(" and s1.stuConsp like '%"+student.getStuConsp()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	public int studentCount(Connection con,Student student)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_student s1,t_grade g where s1.gradeId=g.id");
		if(StringUtil.isNotEmpty(student.getStuNo())){
			sb.append(" and s1.stuNo like '%"+student.getStuNo()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getStuName())){
			sb.append(" and s1.stuName like '%"+student.getStuName()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getSex())){
			sb.append(" and s1.sex like '%"+student.getSex()+"%'");
		}
		if(student.getGradeId()!=-1){
			sb.append(" and s1.gradeId like '%"+student.getGradeId()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getStuDesc())){
			sb.append(" and s1.stuDesc like '%"+student.getStuDesc()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getStuConsp())){
			sb.append(" and s1.stuConsp like '%"+student.getStuConsp()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	public int studentDelete(Connection con,String delIds)throws Exception{
		String sql="delete from t_student where stuId in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}


	public int studentAdd(Connection con,Student student)throws Exception{
		String sql="insert into t_student values(null,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getStuNo());
		pstmt.setString(2, student.getStuName());
		pstmt.setString(3, student.getSex());
		pstmt.setString(4, DateUtil.formatData(student.getBirthday(), "yyyy-MM-dd"));
		pstmt.setInt(5, student.getGradeId());
		pstmt.setString(6, student.getStuDesc());
		pstmt.setString(7, student.getStuConsp());
		return pstmt.executeUpdate();
	}
	
	public int studentModify(Connection con,Student student)throws Exception{
		String sql="update t_student set stuNo=?,stuName=?,sex=?,birthday=?,gradeId=?,stuDesc=?,stuConsp=? where stuId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getStuNo());
		pstmt.setString(2, student.getStuName());
		pstmt.setString(3, student.getSex());
		pstmt.setString(4, DateUtil.formatData(student.getBirthday(), "yyyy-MM-dd"));
		pstmt.setInt(5, student.getGradeId());
		pstmt.setString(6, student.getStuDesc());
		pstmt.setString(7, student.getStuConsp());
		pstmt.setInt(8, student.getStuId());
		return pstmt.executeUpdate();
	}
	
	public boolean getStudentByGradeId(Connection con,String gradeId)throws Exception{
		String sql="select * from t_student where gradeId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, gradeId);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return true;
		}else{
			return false;
		}
	}
}
