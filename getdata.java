

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import dbblood.dbblood;


/**
 * Servlet implementation class getdata
 */
public class getdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<center><h1 style='font-family: Serif;'><b><u>Data of Registered Donar's</u></b></h1></center>");
		pw.print("<center><h1 style='font-family: Serif;'><b><u>Data from Database</u></b></h1></center><br>");
		
	    pw.print("<html><head><title>Result Portal</title><meta name='viewport' content='width=device-width, initial-scale=1'><script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script><style> th,td{ border:1px solid black; border-collapse:collapse;border-background:pink;padding:20px;border-spacing:100px;  border-style=ridge; border-radius:10px;</style></head><br>");
		pw.print("<body bgcolor='#969587';><center><table style='width:100%;'><tr style ='heigth:50px; width:50px; color:black;background-color:#5acbd1;"
				+ "font-family: Serif; '><th style='width:10%; font-family: Serif;'>Name</th><th style='width:10%; font-family: Serif;'>Gender</th><th style='width:50px; font-family: Serif;'>DOB</th><th style='width:50px; font-family: Serif;'>Weight</th><th style='width:50px; font-family: Serif;'>Blood_Group</th><th style='width:50px; font-family: Serif;'>State</th><th style='width:50px; font-family: Serif;'>District</th><th style='width:50px; font-family: Serif;'>Area</th><th style='width:50px; font-family: Serif;'>Mobile</th><th style='width:50px; font-family: Serif;'>Email Id</th><th style='width:50px; font-family: Serif;'>Last Donation</th></tr>");
		
		
	    try {
	    	
	    	Connection con=dbblood.initializeDatabase();
	    	Statement st=con.createStatement();
	    	ResultSet rt=st.executeQuery("select * from blood");
	    	
	    	while(rt.next()) 
	    	{
	    		pw.println("<tr><td> ");
	    		pw.print(rt.getString(1));
	    		pw.print("</td>");
	    		
	    		pw.print("<td>");
	    		pw.print(rt.getString(2));
	    		pw.print("</td>");
	    		
	    		pw.print("<td>");
	    		pw.print(rt.getString(3));
	    		pw.print("</td>");
	    		
	    		pw.print("<td>");
	    		pw.print(rt.getString(4));
	    		pw.print("</td>");
	    		
	    		pw.print("<td>");
	    		pw.print(rt.getString(5));
	    		pw.print("</td>");
	    		
	    		pw.print("<td>");
	    		pw.print(rt.getString(6));
	    		pw.print("</td>");
	    		
	    		pw.print("<td>");
	    		pw.print(rt.getString(7));
	    		pw.print("</td>");
	    		
	    		pw.print("<td>");
	    		pw.print(rt.getString(8));
	    		pw.print("</td>");
	    		
	    		pw.print("<td>");
	    		pw.print(rt.getString(9));
	    		pw.print("</td>");
	    		
	    		pw.print("<td>");
	    		pw.print(rt.getString(10));
	    		pw.print("</td>");
	    		
	    		pw.print("<td>");
	    		pw.print(rt.getString(11));
	    		pw.print("</td>");
	    		pw.print("</tr>");
	    	}
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    pw.print("</table></body></html></center>");
	    pw.print("<a href='bmain.html' style='float:bottom;''font-size:10px;'><input type='submit' value='OKAY' style='background-color:black; float:bottom; font-size:1em; color:white; margin-left:50%; margin-top:5%;border:5px double black;'></a><br><br>");
	}

}
