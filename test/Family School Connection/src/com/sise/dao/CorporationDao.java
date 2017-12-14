package com.sise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sise.model.Corporation;
import com.sise.model.PageBean;
import com.sise.util.StringUtil;

public class CorporationDao {

	public ResultSet corporationList(Connection con,PageBean pageBean,Corporation corporation)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_corporation");
		if(corporation!=null&&StringUtil.isNotEmpty(corporation.getStuName())){
			sb.append(" and stuName like '%"+corporation.getStuName()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int corporationCount(Connection con,Corporation corporation)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_corporation");
		if(StringUtil.isNotEmpty(corporation.getStuName())){
			sb.append(" and stuName like '%"+corporation.getStuName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and","where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	public int corporationDelete(Connection con,String delIds)throws Exception{
		String sql="delete from t_corporation where corId in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	public int corporationAdd(Connection con,Corporation corporation)throws Exception{
		String sql="insert into t_corporation value(null,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,corporation.getStuName());
		pstmt.setString(2,corporation.getCorDesc());
		pstmt.setString(3,corporation.getJob());
		return pstmt.executeUpdate();
	}
	
	public int corporationModify(Connection con,Corporation corporation)throws Exception{
		String sql="update t_corporation set stuName=?,corDesc=?,job=? where corId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, corporation.getStuName());
		pstmt.setString(2, corporation.getCorDesc());
		pstmt.setString(3, corporation.getJob());
		pstmt.setInt(4, corporation.getCorId());
		return pstmt.executeUpdate();
	}
}
