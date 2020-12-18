package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.BookBean;
import dao.BookDao;

public class AddBook extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String callno = req.getParameter("callno");
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		int quantity = Integer.parseInt(req.getParameter("qty"));
		
		BookBean bean = new BookBean(callno, name, author, publisher, quantity);
		int status = BookDao.add(bean);
		
		PrintWriter pw = res.getWriter();
		
		RequestDispatcher rd = req.getRequestDispatcher("addBook.html");
		rd.include(req, res);
		
		if(status==1)
			pw.println("<p style='color:green;position:absolute;top:578px;left:280px'>Book added succesfully</p>");
		else
			pw.println("<p style='color:red;position:absolute;top:578px;left:280px'>Try again</p>");
		
		
	}
}
