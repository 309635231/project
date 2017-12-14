package com.sise.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sise.model.Rap;
import com.sise.model.PageBean;
import com.sise.util.DateUtil;
import com.sise.util.StringUtil;

public class RapDao {

	public ResultSet rapList(Connection con,PageBean pageBean,Rap rap)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_rap");
		if(rap!=null&&StringUtil.isNotEmpty(rap.getStuName())){
			sb.append(" and stuName like '%"+rap.getStuName()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int rapCount(Connection con,Rap rap)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_rap");
		if(StringUtil.isNotEmpty(rap.getStuName())){
			sb.append(" and stuName like '%"+rap.getStuName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and","where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	public int rapDelete(Connection con,String delIds)throws Exception{
		String sql="delete from t_rap where rapId in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	public int rapAdd(Connection con,Rap rap)throws Exception{
		String sql="insert into t_rap value(null,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,rap.getStuName());
		pstmt.setString(2, DateUtil.formatData(rap.getRapDate(), "yyyy-MM-dd"));
		pstmt.setString(3,rap.getRapDesc());
		return pstmt.executeUpdate();
	}
	
	public int rapModify(Connection con,Rap rap)throws Exception{
		String sql="update t_rap set stuName=?,rapDate=?,rapDesc=? where rapId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,rap.getStuName());
		pstmt.setString(2, DateUtil.formatData(rap.getRapDate(), "yyyy-MM-dd"));
		pstmt.setString(3,rap.getRapDesc());
		pstmt.setInt(4,rap.getRapId());
		return pstmt.executeUpdate();
	}
}
