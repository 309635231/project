package com.sise.model;

public class Corporation {
	
	private int corId;
	private String stuName;
	private String corDesc;
	private String job;
	
	
	public Corporation() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	
	
	public Corporation(String stuName, String corDesc,String job) {
		super();
		this.stuName = stuName;
		this.corDesc = corDesc;
		this.job = job;
	}


	public int getCorId() {
		return corId;
	}
	public void setCorId(int corId) {
		this.corId = corId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getCorDesc() {
		return corDesc;
	}
	public void setCorDesc(String corDesc) {
		this.corDesc = corDesc;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}
	
	
}
