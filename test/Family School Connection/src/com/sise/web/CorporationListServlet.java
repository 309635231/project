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

public class CorporationListServlet extends HttpServlet{
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
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		String stuName=request.getParameter("stuName");
		if(stuName==null){
			stuName="";
		}
		Corporation corporation=new Corporation();
		corporation.setStuName(stuName);
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Connection con=null;
		try{
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(corporationDao.corporationList(con, pageBean,corporation));
			int total=corporationDao.corporationCount(con,corporation);
			result.put("rows", jsonArray);
			result.put("total", total);
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
