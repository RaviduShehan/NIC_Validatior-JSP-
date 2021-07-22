package com.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.Database.Connection;
import com.user.model.AppUser;

/**
 * Servlet implementation class ViewServelet
 */
@WebServlet("/ViewServelet")
public class ViewServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServelet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppUser apuser = new AppUser();
         //view db data
 	    List<AppUser> userDetails= Connection.viewDetails(apuser.getNIC());
 		request.setAttribute("userDetails", userDetails);
 		
 		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/View/home.jsp");
 	    dis.forward(request, response);
 	    
	}

}
