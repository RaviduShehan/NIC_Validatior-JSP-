package com.user.Database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.user.model.AppUser;

public class Connection {
	   java.sql.Connection connection;
	
	private static boolean isSuccess;
	public int connectUser(AppUser user) throws ClassNotFoundException {
		
		String sql="INSERT INTO userdetails"+
	"(fullName,address,nationality,nic,birthday,age,gender) VALUES"+
	"(?,?,?,?,?,?,?);";
		
		
	 int result =0;
	 Class.forName("com.mysql.jdbc.Driver");
	 
 
	try {
		connection = DriverManager
				.getConnection("jdbc:mysql://localhost/nicvalidator","root","");
//		Statement st=connection.createStatement();
//		String duplicateCheck = "SELECT COUNT(nic) FROM userdetails where nic='"+user.getNIC()+"'";
//		ResultSet rs=st.executeQuery(duplicateCheck);
//		rs.next();
//		String rowCount = rs.getString(1);
//		if(rowCount.equals("0")) {

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
    	preparedStatement.setString(1, user.getFullName());
    	preparedStatement.setString(2, user.getAddress());
    	preparedStatement.setString(3, user.getNationality());
    	preparedStatement.setString(4, user.getNIC());
    	preparedStatement.setString(5, user.getBirthday());
    	preparedStatement.setInt(6, user.getAge());
    	preparedStatement.setString(7, user.getGender());
    	 
    	result =preparedStatement.executeUpdate();
//		}else {
//		 
//			System.out.println("User NIC already exists !");
//		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return result;
     
      
}
	public static List<AppUser> viewDetails(String nic){
		
		ArrayList<AppUser> user= new ArrayList<>();
		AppUser us= new AppUser();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		java.sql.Connection connection;
		
	
				connection = DriverManager.getConnection("jdbc:mysql://localhost/nicvalidator", "root", "");
			
			Statement st = connection.createStatement();
			String userdata = "SELECT * FROM userdetails where nic='" + nic + "'";
			//String userdata = "SELECT * FROM userdetails ";
			ResultSet rs = st.executeQuery(userdata);
			if(rs.next()) {
				  String name=rs.getString(1);
				  String addressA=rs.getString(2);
				  String national=rs.getString(3);
				  String nid=rs.getString(4);
				  String bday=rs.getString(5);
				  int ageA=rs.getInt(6);
				  String genderA=rs.getString(7);
				  
				  AppUser au = new AppUser(name,addressA,national,nid,bday,ageA,genderA);
				  user.add(au);
			}
			 
		
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return user;
	}
	public static boolean updateUser(String fullname, String address, String nationlty, String nic, String bday, String age, String gender) {
		java.sql.Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/nicvalidator", "root", "");
			Statement st = connection.createStatement();
			String sql = "update userdetails set fullName='"+fullname+"',address='"+address+"',nationality='"+nationlty+"',nic='"+nic+"',birthday='"+bday+"',age='"+age+"',gender='"+gender+"' where nic='"+nic+"'";
			int rst = st.executeUpdate(sql);
			
			if(rst > 0) {
				isSuccess = true;
			}else {
				isSuccess =false;
			}
		}catch (Exception e) {
    		e.printStackTrace();
    	}
		return isSuccess;
	}
}


