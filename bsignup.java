
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
 * Servlet implementation class bsignup
 */
public class bsignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bsignup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String uname=request.getParameter("fname");
		String mail=request.getParameter("email");
		String ps1=request.getParameter("pass1");
		String ps2=request.getParameter("pass2");
		String mob=request.getParameter("phone");
		String gender=request.getParameter("gender1");
		String gender1=request.getParameter("gender2");
		try 
		{
			Connection con=dbblood.initializeDatabase();
			PreparedStatement st=con.prepareStatement("insert into users values(?,?,?,?,?,?,?)");
		
			st.setString(1, uname);
			st.setString(2, mail);
			st.setString(3, ps1);
			st.setString(4, ps2);
			st.setString(5, mob);
			st.setString(6, gender);
			st.setString(7, gender1);
			
			st.executeUpdate();
			PrintWriter out=response.getWriter();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(ps1.equals(ps2))
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("blogin.html");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("bsignup.html");
			rd.forward(request, response);
		}
		
	}

}
