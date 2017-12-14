package com.sise.model;

public class Family {
	private int famId;
	private String stuName;
	private String famName;
	private String famOri;
	private String famNation;
	private String famCompany;
	private String famJob;
	private String famPol;
	private String famAdd;
	

	public Family() {
		super();
	}
	
	
	
	public Family(String stuName,String famName, String famOri, String famNation,
			String famCompany, String famJob, String famPol, String famAdd) {
		super();
		
		this.stuName = stuName;
		this.famName = famName;
		this.famOri = famOri;
		this.famNation = famNation;
		this.famCompany = famCompany;
		this.famJob = famJob;
		this.famPol = famPol;
		this.famAdd = famAdd;
	}
	
	public String getStuName() {
		return stuName;
	}



	public void setStuName(String stuName) {
		this.stuName = stuName;
	}






	public int getFamId() {
		return famId;
	}
	public void setFamId(int famId) {
		this.famId = famId;
	}
	public String getFamName() {
		return famName;
	}
	public void setFamName(String famName) {
		this.famName = famName;
	}
	public String getFamOri() {
		return famOri;
	}
	public void setFamOri(String famOri) {
		this.famOri = famOri;
	}
	public String getFamNation() {
		return famNation;
	}
	public void setFamNation(String famNation) {
		this.famNation = famNation;
	}
	public String getFamCompany() {
		return famCompany;
	}
	public void setFamCompany(String famCompany) {
		this.famCompany = famCompany;
	}
	public String getFamJob() {
		return famJob;
	}
	public void setFamJob(String famJob) {
		this.famJob = famJob;
	}
	public String getFamPol() {
		return famPol;
	}
	public void setFamPol(String famPol) {
		this.famPol = famPol;
	}
	public String getFamAdd() {
		return famAdd;
	}
	public void setFamAdd(String famAdd) {
		this.famAdd = famAdd;
	}
	
	
}
