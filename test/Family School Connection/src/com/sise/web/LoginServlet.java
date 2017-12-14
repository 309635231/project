package com.sise.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sise.dao.UserDao;
import com.sise.model.User;
import com.sise.util.DbUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    DbUtil db=new DbUtil();
    UserDao userDao=new UserDao();
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Connection con=null;
		try{
			User user=new User(username,password);
			con=db.getCon();
			User currentUser=userDao.login(con, user);
				if(currentUser==null){
				request.setAttribute("error","”√ªß√˚√‹¬Î¥ÌŒÛ");
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
			
					HttpSession session=request.getSession();
					session.setAttribute("currentUser",currentUser);
					response.sendRedirect("main.jsp");
				
					
	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
