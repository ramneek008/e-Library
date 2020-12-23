package servlets;

import java.io.IOException;

import javax.servlet.http.*;

import dao.BookDao;

public class DeleteBook extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		String callno = req.getParameter("callno");
		BookDao.delete(callno);
		res.sendRedirect("viewBook.jsp");
	}

}
