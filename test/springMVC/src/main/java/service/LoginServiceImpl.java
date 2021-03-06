package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.AdminDAO;
import entity.Admin;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Resource(name="adminDAO")
	private AdminDAO dao;
	public Admin checkLogin(String username,String pwd){
		Admin admin = null;
		admin=dao.findByUsername(username);
		if(admin==null){
			throw new ApplicationException("�˺Ų�����");
		}
		if(!admin.getPassword().equals(pwd)){
			throw new ApplicationException("������� ");
		}
		return admin;
	}
}
