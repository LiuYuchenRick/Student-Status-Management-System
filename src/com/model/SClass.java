package com.model;

public class SClass {
	// 班级号
	private String sclassNo;
	// 班级名
	private String sclassName;
	public SClass(String sclassNo, String sclassName) {
		super();
		this.sclassNo = sclassNo;
		this.sclassName = sclassName;
	}
	public String getSclassNo() {
		return sclassNo;
	}
	public void setSclassNo(String sclassNo) {
		this.sclassNo = sclassNo;
	}
	public String getSclassName() {
		return sclassName;
	}
	public void setSclassName(String sclassName) {
		this.sclassName = sclassName;
	}
	
	

}
