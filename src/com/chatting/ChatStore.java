package com.chatting;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
/**
 * Servlet implementation class ChatStore
 */
@WebServlet("/ChatStore")
public class ChatStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public ChatStore() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try
	    {
	      response.setContentType("text/html");
	      
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection localConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "aman");
	      Statement localStatement = localConnection.createStatement();
	      
	      String str1 = request.getParameter("uname");
	      String str2 = request.getParameter("msg");
	      
	      SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
	      SimpleDateFormat localSimpleDateFormat2 = new SimpleDateFormat("hh:mm:ss a");
	      Date localDate = new Date();
	      String str3 = localSimpleDateFormat1.format(localDate);
	      String str4 = localSimpleDateFormat2.format(localDate);
	      
	      String str5 = "insert into chatting_data values('" + str1 + "','" + str2 + "','" + str3 + "','" + str4 + "',sq_chatting_data.nextval)";
	      
	      ResultSet localResultSet = localStatement.executeQuery(str5);
	      
	      localResultSet.next();
	      localConnection.close();
	    }
	    catch (Exception localException)
	    {
	      localException.printStackTrace();
	      System.out.println("Invalid User");
	    }
	}
}
