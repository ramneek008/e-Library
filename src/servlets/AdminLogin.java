package servlets;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class AdminLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		
		if(email.equals("admin1@gmail.com") && pwd.equals("123456"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("admin.html");
			rd.include(req,res);
		}
		else
		{
			PrintWriter pw = res.getWriter();
			
			RequestDispatcher rd = req.getRequestDispatcher("adminlogin.html");
			rd.include(req, res);

			pw.println("<p style='color:red;text-align:center;width:99%;position:absolute;top:200px'>Email or password incorrect</p>");
		}
	}

}
