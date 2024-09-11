package com.java.client;

import com.java.Connect.DataConnect;
import com.java.Student.Dao.IStudentDao;
import com.java.demo.Service.StudentService;

public class Main {

	public static void main(String[] args) {


		StudentService ser = new StudentService();
		//ser.addData();
		//ser.remove(0);
		//ser.displayRecords();
		ser.updateRecord();
	}

}
