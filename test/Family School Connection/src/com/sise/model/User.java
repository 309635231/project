package com.sise.model;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String aut;
	
	public User() {
		super();
	}
	public User(String username, String password){
		super();
		this.username = username;
		this.password = password;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getAut() {
		return aut;
	}
	public void setAut(String aut) {
		this.aut = aut;
	}
	
	
}
