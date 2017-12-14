package dao;


import entity.Admin;

public interface AdminDAO {
	public Admin findByUsername(String username);
}
