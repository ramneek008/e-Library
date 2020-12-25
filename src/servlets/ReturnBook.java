package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import dao.BookDao;

public class ReturnBook extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String callno = req.getParameter("bcallno");
		String studentid = req.getParameter("sid");
		
		int status = BookDao.returnBook(callno, studentid);
		
		PrintWriter pw = res.getWriter();
		
		RequestDispatcher rd = req.getRequestDispatcher("returnBook.html");
		rd.include(req, res);
		
		if(status==1)
			pw.println("<p style='color:green;position:absolute;top:355px;left:290px'>Book returned succesfully</p>");
		else
			pw.println("<p style='color:red;position:absolute;top:355px;left:290px'>Try again</p>");
	}
	
}
