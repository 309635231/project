package com.sise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sise.model.Check;
import com.sise.model.PageBean;
import com.sise.util.StringUtil;

public class CheckDao {

	public ResultSet checkList(Connection con,PageBean pageBean,Check check)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_check");
		if(check!=null&&StringUtil.isNotEmpty(check.getStuName())){
			sb.append(" and checkId like '%"+check.getStuName()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int checkCount(Connection con,Check check)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_check");
		if(StringUtil.isNotEmpty(check.getStuName())){
			sb.append(" and checkId like '%"+check.getStuName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and","where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	public int checkDelete(Connection con,String delIds)throws Exception{
		String sql="delete from t_check where checkId in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	public int checkAdd(Connection con,Check check)throws Exception{
		String sql="insert into t_check value(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,check.getStuName());
		pstmt.setString(2,check.getCheckDesc());
		return pstmt.executeUpdate();
	}
	
	public int checkModify(Connection con,Check check)throws Exception{
		String sql="update t_check set checkName=?,checkDesc=? where checkId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, check.getStuName());
		pstmt.setString(2, check.getCheckDesc());
		pstmt.setInt(3, check.getCheckId());
		return pstmt.executeUpdate();
	}
}
