package com.sise.model;

public class Study {
	private int studyId;
	private String stuId;
	private String stuName;
	private String studyDesc;
	
	
	public Study() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	
	
	public Study(String stuId, String stuName, String studyDesc) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.studyDesc = studyDesc;
	}


	public int getStudyId() {
		return studyId;
	}
	public void setStudyId(int studyId) {
		this.studyId = studyId;
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
	public String getStudyDesc() {
		return studyDesc;
	}
	public void setStudyDesc(String studyDesc) {
		this.studyDesc = studyDesc;
	}
	
	
}
