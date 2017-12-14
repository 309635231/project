package com.sise.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sise.dao.FamilyDao;
import com.sise.model.Family;
import com.sise.model.PageBean;
import com.sise.util.DbUtil;
import com.sise.util.JsonUtil;
import com.sise.util.ResponseUtil;
import com.sise.util.StringUtil;

public class FamilySaveServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	FamilyDao familyDao=new FamilyDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String famId=request.getParameter("famId");
		String stuName=request.getParameter("stuName");
		String famName=request.getParameter("famName");
		String famOri=request.getParameter("famOri");
		String famNation=request.getParameter("famNation");
		String famCompany=request.getParameter("famCompany");
		String famJob=request.getParameter("famJob");
		String famPol=request.getParameter("famPol");
		String famAdd=request.getParameter("famAdd");
		Family family=new Family(stuName,famName,famOri,famNation,famCompany,famJob,famPol,famAdd);
		if(StringUtil.isNotEmpty(famId)){
			family.setFamId(Integer.parseInt(famId));
		}
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int saveNums=0;
			JSONObject result=new JSONObject();
			if(StringUtil.isNotEmpty(famId)){
				saveNums=familyDao.familyModify(con,family);
			}else{
				saveNums=familyDao.familyAdd(con,family);
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
