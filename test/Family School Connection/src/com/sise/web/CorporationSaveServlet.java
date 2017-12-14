package com.sise.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sise.dao.CorporationDao;
import com.sise.model.Corporation;
import com.sise.model.PageBean;
import com.sise.util.DbUtil;
import com.sise.util.JsonUtil;
import com.sise.util.ResponseUtil;
import com.sise.util.StringUtil;

public class CorporationSaveServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	CorporationDao corporationDao=new CorporationDao();
	
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
		String corDesc=request.getParameter("corDesc");
		String job=request.getParameter("job");
		String corId=request.getParameter("corId");
		Corporation corporation=new Corporation(stuName,corDesc,job);
		if(StringUtil.isNotEmpty(corId)){
			corporation.setCorId(Integer.parseInt(corId));
		}
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int saveNums=0;
			JSONObject result=new JSONObject();
			if(StringUtil.isNotEmpty(corId)){
				saveNums=corporationDao.corporationModify(con,corporation);
			}else{
				saveNums=corporationDao.corporationAdd(con,corporation);
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
