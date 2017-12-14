package com.sise.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sise.dao.RapDao;
import com.sise.model.Rap;
import com.sise.model.PageBean;
import com.sise.util.DateUtil;
import com.sise.util.DbUtil;
import com.sise.util.JsonUtil;
import com.sise.util.ResponseUtil;
import com.sise.util.StringUtil;

public class RapSaveServlet extends HttpServlet{
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
		request.setCharacterEncoding("utf-8");
		String stuName=request.getParameter("stuName");
		String rapDate=request.getParameter("rapDate");
		String rapDesc=request.getParameter("rapDesc");
		String rapId=request.getParameter("rapId");
		Rap rap=null;
		try {
			rap = new Rap(stuName,DateUtil.formatString(rapDate, "yyyy-MM-dd"),rapDesc);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(StringUtil.isNotEmpty(rapId)){
			rap.setRapId(Integer.parseInt(rapId));
		}
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int saveNums=0;
			JSONObject result=new JSONObject();
			if(StringUtil.isNotEmpty(rapId)){
				saveNums=rapDao.rapModify(con,rap);
			}else{
				saveNums=rapDao.rapAdd(con,rap);
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
