

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import dbblood.dbblood;

/**
 * Servlet implementation class bregistered
 */
public class bregistered extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bregistered() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("uname");
		String gender=request.getParameter("gender");
		String Dob=request.getParameter("dob");
		String Weight=request.getParameter("weight");
		String Blood=request.getParameter("bgroup");
		String state=request.getParameter("state");
		String District=request.getParameter("District");
		String Area=request.getParameter("Area");
		String mob=request.getParameter("mob");
		String Email=request.getParameter("mail");
		String lastdonation=request.getParameter("lod");
		
		try
		{
			Connection con=dbblood.initializeDatabase();
			PreparedStatement st=con.prepareStatement("insert into blood values(?,?,?,?,?,?,?,?,?,?,?)");
		
			st.setString(1, name);
			st.setString(2, gender);
			st.setString(3, Dob);
			st.setString(4, Weight);
			st.setString(5, Blood);
			st.setString(6, state);
			st.setString(7, District);
			st.setString(8, Area);
			st.setString(9, mob);
			st.setString(10, Email);
			st.setString(11, lastdonation);
			
			st.executeUpdate();
			out=response.getWriter();
			
			response.sendRedirect("getdata");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
