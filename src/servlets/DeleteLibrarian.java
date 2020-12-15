package servlets;

import java.io.IOException;

import javax.servlet.http.*;

import dao.LibrarianDao;

public class DeleteLibrarian extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int id = Integer.parseInt(req.getParameter("id"));
		LibrarianDao.delete(id);
		res.sendRedirect("viewLibrarian.jsp");
	}
}
