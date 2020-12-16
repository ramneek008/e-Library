package servlets;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import dao.DBConnectivity;

public class LibrarianLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		
		try {
			Connection con = DBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from HR.E_LIBRARIAN where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				if(password.equals(rs.getString("password")))
				{
					RequestDispatcher rd = req.getRequestDispatcher("librarian.html");
					rd.include(req, res);
				}
				else
				{
					PrintWriter pw = res.getWriter();
					RequestDispatcher rd = req.getRequestDispatcher("index.html");
					rd.include(req, res);
					pw.println("<p style='color:red;text-align:center;width:99%;position:absolute;top:200px'>Email or password incorrect</p>");
					
				}
			}
			else
			{
				PrintWriter pw = res.getWriter();
				RequestDispatcher rd = req.getRequestDispatcher("index.html");
				rd.include(req, res);
				pw.println("<p style='color:red;text-align:center;width:99%;position:absolute;top:200px'>Email or password incorrect</p>");
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
