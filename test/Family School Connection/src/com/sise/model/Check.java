package com.sise.model;

public class Check {
	private int checkId;
	private String stuName;
	private String checkDesc;
	
	
	
	public Check() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public Check(String stuName,String checkDesc) {
		super();
		this.stuName = stuName;
		this.checkDesc = checkDesc;
	}

	public int getCheckId() {
		return checkId;
	}
	public void setCheckId(int checkId) {
		this.checkId = checkId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getCheckDesc() {
		return checkDesc;
	}
	public void setCheckDesc(String checkDesc) {
		this.checkDesc = checkDesc;
	}
	
	
}
