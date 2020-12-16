package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.LibrarianBean;
import dao.LibrarianDao;

public class EditLibrarian extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		long mobile = Long.parseLong(req.getParameter("mob"));
		
		LibrarianBean bean = new LibrarianBean(id, name, email, password, mobile);
		int t = LibrarianDao.edit(bean);
		
		res.sendRedirect("viewLibrarian.jsp");
		
	}
}
