package service;

import entity.Admin;

public interface LoginService {
	public Admin checkLogin(String username, String pwd);
}	
