package com.sise.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sise.dao.CourseDao;
import com.sise.model.Course;
import com.sise.model.PageBean;
import com.sise.util.DbUtil;
import com.sise.util.JsonUtil;
import com.sise.util.ResponseUtil;
import com.sise.util.StringUtil;

public class CourseSaveServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	CourseDao courseDao=new CourseDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String stuName=request.getParameter("stuName");
		String couCode=request.getParameter("couCode");
		String couName=request.getParameter("couName");
		String couCredit=request.getParameter("couCredit");
		String couScores=request.getParameter("couScores");
		String couId=request.getParameter("couId");
		Course course=new Course(stuName, couCode, couName, Double.parseDouble(couCredit), couScores);
		if(StringUtil.isNotEmpty(couId)){
			course.setCouId(Integer.parseInt(couId));
		}
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int saveNums=0;
			JSONObject result=new JSONObject();
			if(StringUtil.isNotEmpty(couId)){
				saveNums=courseDao.courseModify(con,course);
			}else{
				saveNums=courseDao.courseAdd(con,course);
			}
			if(saveNums>0){
				result.put("success", "true");
			}else{
				result.put("success", "true");
				result.put("errorMsg", "É¾³ýÊ§°Ü");
			}
			ResponseUtil.write(response, result);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.getClose(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
}
