package com.java.demo.Service;

import java.util.Scanner;

import com.java.Model.Student;
import com.java.Student.Dao.IStudentDao;

public class StudentService {
	
	Scanner sc ;
	IStudentDao dao;
	
	public StudentService() {
		sc=new Scanner(System.in);
		dao=new IStudentDao();
	}
	
	public void addData()
	{
		Student s =new Student();
		System.out.println("enter roll no ");
		s.setRollno(sc.nextInt());
			
		System.out.println("enter name no ");
		sc.nextLine();
		s.setName(sc.nextLine());
			
		System.out.println("enter fee");
		s.setFee(sc.nextDouble());
			
		dao.insert1(s);		
	}
		
	public void remove(int roll) {
		System.out.println("Enter the roll no to remove from record:");
		int rollNo=sc.nextInt();
		
		dao.remove(rollNo);
	}
	
	public void displayRecords() {
		System.out.println(" ");
		System.out.println("The records of the student table are : ");
		dao.showAll();
	}
	
	public void updateRecord() {
		System.out.println(" ");
		System.out.println("Enter the roll no:");
		int roll=sc.nextInt();
		
		System.out.println("Enter the new fee:");
		double fee=sc.nextDouble();
		
		dao.updateFee(roll, fee);
	}
	
	
}
