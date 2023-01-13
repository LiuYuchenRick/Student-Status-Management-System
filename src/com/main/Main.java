package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.model.Student;
import com.util.DbUtil;

public class Main {
	private static  Scanner input = new Scanner(System.in);// 输入流
	public static void main(String[] args) throws Exception {	
        while (true) {
            System.out.println("----------学生信息管理系统----------");
            System.out.println("---------1.添加学生信息---------");
            System.out.println("---------2.修改学生信息---------");
            System.out.println("---------3.查询学生信息---------");
            System.out.println("---------4.显示所有学生---------");
            System.out.println("---------5.删除学生信息---------");
            System.out.println("---------6.退出系统------------");
            // 用户输入，匹配不同功能
            System.out.print("请选择:");
            String choose = input.nextLine();
            switch (choose) {
                case "1":
                	// 添加学生信息
                	addStudent();
                    break;
                case "2":
                	// 修改学生信息
                	updateStudent();
                    break;
                case "3":
                	// 查询学生信息
                    findStudent();
                    break;
                case "4":
                	// 显示所有学生
                    findAllStudent();
                    break;
                case "5":
                	// 删除学生信息
                	deleteStudent();
                	break;
                case "6":
                	 System.out.println("谢谢你的使用");
                     System.exit(0);
                default:
                   System.out.println("输入有误!");
                    break;
            }
        }
		
	}
	// 删除学生
	private static void deleteStudent() throws Exception {
		System.out.println("输入学号:");
		String no = input.nextLine();
		Connection con = DbUtil.getCon();
		String sqlString = "select * from student where no =? ";
		PreparedStatement preparedStatement = con.prepareStatement(sqlString);
		preparedStatement.setString(1, no);
        ResultSet rs = preparedStatement.executeQuery();
        boolean flag=true;
        if (rs.next()) {
        	flag=false;
        }
		if(flag) {
			System.out.println("该学号不存在!");
		}else {
			String sql = "delete from student where no=?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, no);
			preparedStatement.execute();
			System.out.println("删除成功!");
			
		}	
		
	}
	// 查询所有学生
	private static void findAllStudent() throws Exception {
		Connection con = DbUtil.getCon();
		String sqlString = "select * from student";
		PreparedStatement preparedStatement = con.prepareStatement(sqlString);
        ResultSet rs = preparedStatement.executeQuery();
        // 遍历打印所有
        while(rs.next()) {
        	Student student= new Student();
        	student.setNo(rs.getString(1));
        	student.setName(rs.getString(2));
        	student.setSex(rs.getString(3));
        	student.setAge(rs.getInt(4));
        	student.setGrade(rs.getString(5));
        	student.setMajor(rs.getString(6));
        	student.setSclassNo(rs.getString(7));
        	student.setInDate(rs.getString(8));
        	System.out.println(student);
        }
		
	}
	// 查找学生
	private static void findStudent() throws Exception {
		System.out.println("输入学号:");
		String no = input.nextLine();
		// 确定学号是否在
		Connection con = DbUtil.getCon();
		String sqlString = "select * from student where no =?";
		PreparedStatement preparedStatement = con.prepareStatement(sqlString);
		preparedStatement.setString(1, no);
        ResultSet rs = preparedStatement.executeQuery();
        boolean flag=true;
        if (rs.next()) {
        	flag=false;
        	// 存在打印学生信息
        	Student student= new Student();
        	student.setNo(rs.getString(1));
        	student.setName(rs.getString(2));
        	student.setSex(rs.getString(3));
        	student.setAge(rs.getInt(4));
        	student.setGrade(rs.getString(5));
        	student.setMajor(rs.getString(6));
        	student.setSclassNo(rs.getString(7));
        	student.setInDate(rs.getString(8));
        	System.out.println(student);
        }
		if(flag) {
			// 不存在
			System.out.println("该学生不存在!");
		}
		
	}
	// 更新学生
	private static void updateStudent() throws Exception {
		System.out.println("输入学号:");
		String no = input.nextLine();
		// 确定学号是否在
		Connection con = DbUtil.getCon();
		String sqlString = "select * from student where no =? ";
		PreparedStatement preparedStatement = con.prepareStatement(sqlString);
		preparedStatement.setString(1, no);
        ResultSet rs = preparedStatement.executeQuery();
        boolean flag=true;
        if (rs.next()) {
        	flag=false;
        }
		if(flag) {
			// 学号不存在
			System.out.println("该学号不存在!");
		}else {
			// 学号存在更新学生信息
			System.out.println("输入姓名:");
			String name = input.nextLine();
			System.out.println("输入性别:");
			String sex = input.nextLine();
			System.out.println("输入年龄:");
			int age = Integer.parseInt(input.nextLine());
			System.out.println("输入年级:");
			String grade = input.nextLine();
			System.out.println("输入专业:");
			String major = input.nextLine();
			System.out.println("输入班级号:");
			String sclassNo = input.nextLine();
			System.out.println("输入进入班级时间(2023-01-13):");
			String inDate = input.nextLine();
			Student student = new Student(no, name, sex, age, grade, major, sclassNo,inDate);
			String sql = "update student set name=?,sex=?,age=?,grade=?,major=?,sclassNo=?,inDate=? where no=?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getSex());
			preparedStatement.setInt(3, student.getAge());
			preparedStatement.setString(4, student.getGrade());
			preparedStatement.setString(5, student.getMajor());
			preparedStatement.setString(6, student.getSclassNo());
			preparedStatement.setString(7, student.getInDate());
			preparedStatement.setString(8, no);
			try {
				preparedStatement.execute();
				System.out.println("更新成功!");
			}catch(Exception e) {
				System.out.println("该班级号不存在");
			}
			
			
		}	
		
	}
	// 添加学生
	private static void addStudent() throws Exception {
		System.out.println("输入学号:");
		String no = input.nextLine();
		// 确定学号是否在
		Connection con = DbUtil.getCon();
		String sqlString = "select * from student where no =? ";
		PreparedStatement preparedStatement = con.prepareStatement(sqlString);
		preparedStatement.setString(1, no);
        ResultSet rs = preparedStatement.executeQuery();
        boolean flag=false;
        if (rs.next()) {
        	flag=true;
        }
		if(flag) {// 学号已存在
			System.out.println("该学号已存在!");
		}else {
			System.out.println("输入姓名:");
			String name = input.nextLine();
			System.out.println("输入性别:");
			String sex = input.nextLine();
			System.out.println("输入年龄:");
			int age = Integer.parseInt(input.nextLine());
			System.out.println("输入年级:");
			String grade = input.nextLine();
			System.out.println("输入专业:");
			String major = input.nextLine();
			System.out.println("输入班级号:");
			String sclassNo = input.nextLine();
			System.out.println("输入进入班级时间(2023-01-13):");
			String inDate = input.nextLine();
			Student student = new Student(no, name, sex, age, grade, major, sclassNo,inDate);
			String sql = "insert into student values(?,?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getNo());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getSex());
			preparedStatement.setInt(4, student.getAge());
			preparedStatement.setString(5, student.getGrade());
			preparedStatement.setString(6, student.getMajor());
			preparedStatement.setString(7, student.getSclassNo());
			preparedStatement.setString(8, student.getInDate());
			try {
				preparedStatement.execute();
				System.out.println("添加成功!");
			}catch(Exception e) {
				System.out.println("该班级号不存在");
			}
			
			
		}	
	}

}
