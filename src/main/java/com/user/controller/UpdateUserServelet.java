package com.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.Database.Connection;

/**
 * Servlet implementation class UpdateDetails
 */
@WebServlet("/UpdateDetails")
public class UpdateUserServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/updateUser.jsp");
//		dispatcher.forward(request, response);
//	}
//	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String fName = request.getParameter("fullName");
  		String addressA = request.getParameter("address");
  		String nation = request.getParameter("nationality");
  		String nic = request.getParameter("NIC");
  		String bday = request.getParameter("birthday");
  		String age = request.getParameter("age");
  		String gender = request.getParameter("gender");
  		//int Age = Integer.parseInt(age);
  		
  		boolean isTrue;
  		Connection co = new Connection();
  		isTrue = co.updateUser(fName, addressA, nation, nic, bday, age, gender);
  		if(isTrue == true) {
  			RequestDispatcher d= request.getRequestDispatcher("/WEB-INF/View/success.jsp");
  			d.forward(request, response);
  		}else {
  			RequestDispatcher d= request.getRequestDispatcher("/WEB-INF/View/invalid.jsp");
  			d.forward(request, response);
  		}
  	   
	}

}
