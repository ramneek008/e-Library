package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.LibrarianBean;
import dao.LibrarianDao;

public class AddLibrarian extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		long mobile = Long.parseLong(req.getParameter("mob"));
		LibrarianBean bean = new LibrarianBean(name, email, password, mobile);
		int t=LibrarianDao.save(bean);
		
		PrintWriter pw = res.getWriter();
		if(t==1)
			pw.println("<p style='color:green;position:absolute;top:500px;left:250px'>Librarian added succesfully</p>");
		else
			pw.println("<p style='color:red;position:absolute;top:500px;left:250px'>Try again</p>");
		
		RequestDispatcher rd = req.getRequestDispatcher("addLibrarian.html");
		rd.include(req, res);
		
		
			
	}
}
