package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.IssueBookBean;
import dao.BookDao;

public class IssueBook extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String callno = req.getParameter("bcallno");
		String studentid = req.getParameter("sid");
		String studentname = req.getParameter("sname");
		long studentmobile = Long.parseLong(req.getParameter("smob"));
		
		IssueBookBean bean = new IssueBookBean(callno, studentid, studentname, studentmobile);
		int status = BookDao.issueBook(bean);
		
		PrintWriter pw = res.getWriter();
		
		RequestDispatcher rd = req.getRequestDispatcher("issueBook.html");
		rd.include(req, res);
		
		if(status==1)
			pw.println("<p style='color:green;position:absolute;top:505px;left:280px'>Book issued succesfully</p>");
		else
			pw.println("<p style='color:red;position:absolute;top:505px;left:280px'>Try again</p>");
	}
}
