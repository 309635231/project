package com.sise.model;

import java.util.Date;

public class Rap {
	
	private int rapId;
	private String stuName;
	private Date rapDate;
	private String rapDesc;
	
	
	
	public Rap() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Rap(String stuName, Date rapDate, String rapDesc) {
		super();
		this.stuName = stuName;
		this.rapDate = rapDate;
		this.rapDesc = rapDesc;
	}
	public int getRapId() {
		return rapId;
	}
	public void setRapId(int rapId) {
		this.rapId = rapId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Date getRapDate() {
		return rapDate;
	}
	public void setRapDate(Date rapDate) {
		this.rapDate = rapDate;
	}
	public String getRapDesc() {
		return rapDesc;
	}
	public void setRapDesc(String rapDesc) {
		this.rapDesc = rapDesc;
	}
	
	
}
