package com.sise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sise.model.Home;
import com.sise.model.PageBean;
import com.sise.util.StringUtil;

public class HomeDao {

	public ResultSet homeList(Connection con,PageBean pageBean,Home home)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_home");
		if(home!=null&&StringUtil.isNotEmpty(home.getStuId())){
			sb.append(" and stuId like '%"+home.getStuId()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int homeCount(Connection con,Home home)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_home");
		if(StringUtil.isNotEmpty(home.getStuId())){
			sb.append(" and stuId like '%"+home.getStuId()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and","where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	public int homeDelete(Connection con,String delIds)throws Exception{
		String sql="delete from t_home where homeId in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	public int homeAdd(Connection con,Home home)throws Exception{
		String sql="insert into t_home value(null,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,home.getStuId());
		pstmt.setString(2,home.getStuName());
		pstmt.setString(3,home.getHomeDesc());
		return pstmt.executeUpdate();
	}
	
	public int homeModify(Connection con,Home home)throws Exception{
		String sql="update t_home set stuId=?,stuName=?,homeDesc=? where homeId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, home.getStuId());
		pstmt.setString(2, home.getStuName());
		pstmt.setString(3, home.getHomeDesc());
		pstmt.setInt(4, home.getHomeId());
		return pstmt.executeUpdate();
	}
}
