package com.chatting;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Chat")
public class Chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Chat() {
        super();
    }
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    PrintWriter localPrintWriter = response.getWriter();
	    try
	    {
	      response.setContentType("text/html");
	      
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection localConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "aman");
	      Statement localStatement = localConnection.createStatement();
	      
	      String str1 = request.getParameter("uname");
	      String str2 = request.getParameter("pw");
	      String str3 = "select*from chatting where username='" + str1 + "' AND password='" + str2 + "'";
	      
	      ResultSet localResultSet = localStatement.executeQuery(str3);
	      if (localResultSet.next())
	      {
	        String str4 = localResultSet.getString("username");
	        HttpSession localHttpSession = request.getSession();
	        localHttpSession.setAttribute("name", str4);
	        localPrintWriter.println("Welcome, " + str4.toUpperCase());
	        localPrintWriter.println("<a href='startchat.jsp'>let's Enter the Chat Room</a>");
	        localPrintWriter.println("<a href='logout.jsp' class='logout-chat'>Logout</a>");
	      }
	      else
	      {
	        localPrintWriter.println("Incorrect Username or Password.");
	      }
	      localConnection.close();
	    }
	    catch (Exception localException)
	    {
	      localException.printStackTrace();
	      System.out.println("Invalid User");
	    }
	}
}
