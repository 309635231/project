package com.sise.model;

public class Course {
	
	private int couId;
	private String stuName;
	private String couCode;
	private String couName;
	private double couCredit;
	private String couScores;
	
	
	public Course() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Course(String stuName, String couCode, String couName,
			Double couCredit, String couScores) {
		super();
		this.stuName = stuName;
		this.couCode = couCode;
		this.couName = couName;
		this.couCredit = couCredit;
		this.couScores = couScores;
	}
	public int getCouId() {
		return couId;
	}
	public void setCouId(int couId) {
		this.couId = couId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getCouCode() {
		return couCode;
	}
	public void setCouCode(String couCode) {
		this.couCode = couCode;
	}
	public String getCouName() {
		return couName;
	}
	public void setCouName(String couName) {
		this.couName = couName;
	}
	public double getCouCredit() {
		return couCredit;
	}
	public void setCouCredit(double couCredit) {
		this.couCredit = couCredit;
	}
	public String getCouScores() {
		return couScores;
	}
	public void setCouScores(String couScores) {
		this.couScores = couScores;
	}
	
	
}
