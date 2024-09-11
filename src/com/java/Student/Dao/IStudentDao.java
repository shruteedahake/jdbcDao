package com.java.Student.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.Connect.DataConnect;
import com.java.Model.Student;

public class IStudentDao {
	
	Connection con;
	PreparedStatement stat;
	public IStudentDao()
	{
		con=DataConnect.getConnect();
		
	}
	   
	public void insert1(Student s) 
	{
		try
		{
			stat=con.prepareStatement("insert into student values(?,?,?)");
			stat.setInt(1, s.getRollno());
			stat.setString(2, s.getName());
			stat.setDouble(3,s.getFee());
		
			stat.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}	
	}

	public void remove(int roll)
	{
		try {
			stat=con.prepareStatement("delete from student where rollno=?");
			stat.setInt(1, roll);
			int k=stat.executeUpdate();
			
			if(k>0) {
				System.out.println("Record deleted successfully.");
			}else {
				System.out.println("Not successful.");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void showAll() {
		try {
			stat=con.prepareStatement("select * from student");
			ResultSet rs=stat.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDouble(3));
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateFee(int roll,double fee) {
		try {
			stat=con.prepareStatement("update student set Fee=? where RollNo=?");
			stat.setInt(1, roll);
			stat.setDouble(2, fee);
			int k=stat.executeUpdate();
			
			if(k>0) {
				System.out.println("Record updated successfully.");
			}else {
				System.out.println("Not successful.");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
