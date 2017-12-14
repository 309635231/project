package com.sise.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sise.dao.UserDao;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");  
        String password = request.getParameter("password");  
        String rpsw = request.getParameter("rpsw");//�õ������������  
        if(!password.equals(rpsw)){  
            request.setAttribute("msg", "������������벻ͬ");  
            request.getRequestDispatcher("/register.jsp").forward(request, response);  
            return;  
        }  
        UserDao u = new UserDao();  
        u.addUser(username,password);//����addUser��������  
        request.setAttribute("msg", "��ϲ��"+username+"��ע��ɹ�");  
        request.getRequestDispatcher("/login.jsp").forward(request, response);  
  
    }  

}
