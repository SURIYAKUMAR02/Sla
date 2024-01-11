

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbblood.dbblood;

/**
 * Servlet implementation class bsignin
 */
public class bsignin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bsignin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		RequestDispatcher dp=null;
		
		String lmail=request.getParameter("lemail");
        String lpass=request.getParameter("lpass");
        
		
	try {
		Connection con=dbblood.initializeDatabase();
		
		String query=("select * from users where email='"+lmail+"' and pass1='"+lpass+"'");
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery(query);
		 
		  if(rs.next()){
	        	
        	  dp=request.getRequestDispatcher("bmain.html");
              dp.forward(request, response);

		 }
		  else 
		 {
			 
			 dp=request.getRequestDispatcher("/blogin.html");
			 dp.include(request, response);
		 }
         

	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
