package com.sise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sise.model.Study;
import com.sise.model.PageBean;
import com.sise.util.StringUtil;

public class StudyDao {

	public ResultSet studyList(Connection con,PageBean pageBean,Study study)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_study");
		if(study!=null&&StringUtil.isNotEmpty(study.getStuId())){
			sb.append(" and stuId like '%"+study.getStuId()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int studyCount(Connection con,Study study)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_study");
		if(StringUtil.isNotEmpty(study.getStuId())){
			sb.append(" and stuId like '%"+study.getStuId()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and","where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	public int studyDelete(Connection con,String delIds)throws Exception{
		String sql="delete from t_study where studyId in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	public int studyAdd(Connection con,Study study)throws Exception{
		String sql="insert into t_study value(null,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,study.getStuId());
		pstmt.setString(2,study.getStuName());
		pstmt.setString(3,study.getStudyDesc());
		return pstmt.executeUpdate();
	}
	
	public int studyModify(Connection con,Study study)throws Exception{
		String sql="update t_study set stuId=?,stuName=?,studyDesc=? where studyId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, study.getStuId());
		pstmt.setString(2, study.getStuName());
		pstmt.setString(3, study.getStudyDesc());
		pstmt.setInt(4, study.getStudyId());
		return pstmt.executeUpdate();
	}
}
