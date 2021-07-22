package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.Database.Connection;
import com.user.model.*;

/**
 * Servlet implementation class UserServelet
 */
@WebServlet("/addUser")
public class UserServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection userconnection = new Connection();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/AddUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullName = request.getParameter("fullName");
		String address = request.getParameter("address");
		String nationality = request.getParameter("nationality");
		String NIC = request.getParameter("NIC");
		 

		AppUser apuser = new AppUser();
		apuser.setFullName(fullName);
		apuser.setAddress(address);
		apuser.setNationality(nationality);
		apuser.setNIC(NIC);
		apuser.setGender(NIC);
		Boolean validity = apuser.getValidity();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/nicvalidator", "root", "");
			Statement st = connection.createStatement();
			String duplicateCheck = "SELECT COUNT(nic) FROM userdetails where nic='" + apuser.getNIC() + "'";
			ResultSet rs = st.executeQuery(duplicateCheck);
			rs.next();
			String rowCount = rs.getString(1);
			if (rowCount.equals("0")) {

				if (validity == true) {
					//add details to db
		            userconnection.connectUser(apuser);
		            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/success.jsp");
					dispatcher.forward(request, response);
		    	  
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/invalid.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert('User NIC already exists');");
				out.println("location='success.jsp'");
				out.println("</script>");
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
