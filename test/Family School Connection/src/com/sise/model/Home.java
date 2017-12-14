package com.sise.model;

public class Home {
	private int homeId;
	private String stuId;
	private String stuName;
	private String homeDesc;
	
	
	public Home() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Home(String stuId, String stuName, String homeDesc) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.homeDesc = homeDesc;
	}
	public int getHomeId() {
		return homeId;
	}
	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getHomeDesc() {
		return homeDesc;
	}
	public void setHomeDesc(String homeDesc) {
		this.homeDesc = homeDesc;
	}
	
	
}
