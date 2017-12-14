package com.sise.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sise.dao.RapDao;
import com.sise.model.Rap;
import com.sise.model.PageBean;
import com.sise.util.DbUtil;
import com.sise.util.JsonUtil;
import com.sise.util.ResponseUtil;

public class RapListServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	RapDao rapDao=new RapDao();
	
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
		Rap rap=new Rap();
		rap.setStuName(stuName);
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Connection con=null;
		try{
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(rapDao.rapList(con, pageBean,rap));
			int total=rapDao.rapCount(con,rap);
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
