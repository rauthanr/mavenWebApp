package com.ravio.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;


/**
 * Servlet implementation class TestDBUserServlet
 */
public class TestDBUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDBUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	//response.getWriter().append("Served at: ").append(request.getContextPath());

    	String user = "springstudent";
    	String pass = "springstudent";

    	String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker";

    	String driver = "com.mysql.jdbc.Driver";
    	com.mysql.jdbc.Driver driver1 = null;

    	try {
    		PrintWriter out = response.getWriter();
    		out.println("Conecting to database " + jdbcUrl);

    		Class.forName(driver);

    		Connection myconn = DriverManager.getConnection(jdbcUrl, user, pass);
    		out.println(" !! Success !! ");
    		myconn.close();


    	}catch(Exception ex) {
    		ex.printStackTrace();
    		throw new ServletException();
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
