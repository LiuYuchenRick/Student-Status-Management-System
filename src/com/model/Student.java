package com.model;

public class Student {
	private String no;// 学号
	private String name;// 名字
	private String sex;// 性别
	private int age;// 年龄
	private String grade;// 年级
	private String major;// 专业
	private String sclassNo;// 班级
	private String inDate;// 进入班级时间

	public Student() {

	}

	public Student(String no, String name, String sex, int age, String grade, String major, String sclassNo,
			String inDate) {
		super();
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.grade = grade;
		this.major = major;
		this.sclassNo = sclassNo;
		this.inDate = inDate;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSclassNo() {
		return sclassNo;
	}

	public void setSclassNo(String sclassNo) {
		this.sclassNo = sclassNo;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	@Override
	public String toString() {
		return "学号:" + no + ", 姓名:" + name + ", 性别:" + sex + ", 年龄:" + age + ", 年级:" + grade + ", 专业:" + major
				+ ", 班级号:" + sclassNo + ",进入班级时间:" + inDate;
	}

}
