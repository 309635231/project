package com.sise.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sise.dao.HomeDao;
import com.sise.model.Home;
import com.sise.model.PageBean;
import com.sise.util.DbUtil;
import com.sise.util.JsonUtil;
import com.sise.util.ResponseUtil;
import com.sise.util.StringUtil;

public class HomeSaveServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	HomeDao homeDao=new HomeDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String stuId=request.getParameter("stuId");
		String stuName=request.getParameter("stuName");
		String homeDesc=request.getParameter("homeDesc");
		String homeId=request.getParameter("homeId");
		Home home=new Home(stuId,stuName,homeDesc);
		if(StringUtil.isNotEmpty(homeId)){
			home.setHomeId(Integer.parseInt(homeId));
		}
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int saveNums=0;
			JSONObject result=new JSONObject();
			if(StringUtil.isNotEmpty(homeId)){
				saveNums=homeDao.homeModify(con,home);
			}else{
				saveNums=homeDao.homeAdd(con,home);
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
