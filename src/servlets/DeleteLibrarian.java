package servlets;

import java.io.IOException;

import javax.servlet.http.*;

import dao.LibrarianDao;

public class DeleteLibrarian extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		String email = req.getParameter("email");
		System.out.println(email);
		LibrarianDao.delete(email);
		res.sendRedirect("viewLibrarian.jsp");
	}
}
