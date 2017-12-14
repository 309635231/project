package com.sise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sise.model.Family;
import com.sise.model.Grade;
import com.sise.model.PageBean;
import com.sise.model.Student;
import com.sise.util.DateUtil;
import com.sise.util.StringUtil;

public class FamilyDao {

	public ResultSet familyList(Connection con,PageBean pageBean,Family family)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_family");
		if(family!=null&&StringUtil.isNotEmpty(family.getStuName())){
			sb.append(" and stuName like '%"+family.getStuName()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int familyCount(Connection con,Family family)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_family");
		if(StringUtil.isNotEmpty(family.getStuName())){
			sb.append(" and stuName like '%"+family.getStuName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and","where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	public int familyDelete(Connection con,String delIds)throws Exception{
		String sql="delete from t_family where famId in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	public int familyAdd(Connection con,Family family)throws Exception{
		String sql="insert into t_family value(null,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,family.getStuName());
		pstmt.setString(2,family.getFamName());
		pstmt.setString(3,family.getFamOri());
		pstmt.setString(4,family.getFamNation());
		pstmt.setString(5,family.getFamCompany());
		pstmt.setString(6,family.getFamJob());
		pstmt.setString(7,family.getFamPol());
		pstmt.setString(8,family.getFamAdd());
		return pstmt.executeUpdate();
	}
	
	public int familyModify(Connection con,Family family)throws Exception{
		String sql="update t_family set stuName=?,famName=?,famOri=?,famNation=?,famCompany=?,famJob=?,famPol=?,famAdd=? where famId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, family.getStuName());
		pstmt.setString(2, family.getFamName());
		pstmt.setString(3, family.getFamOri());
		pstmt.setString(4, family.getFamNation());
		pstmt.setString(5, family.getFamCompany());
		pstmt.setString(6, family.getFamJob());
		pstmt.setString(7, family.getFamPol());
		pstmt.setString(8, family.getFamAdd());
		pstmt.setInt(9, family.getFamId());
		return pstmt.executeUpdate();
	}
}
