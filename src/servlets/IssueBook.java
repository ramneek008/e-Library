package servlets;

import javax.servlet.http.*;

import bean.IssueBookBean;

public class IssueBook extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		String bookcallno = req.getParameter("bcallno");
		String studentid = req.getParameter("sid");
		String studentname = req.getParameter("sname");
		long studentmobile = Long.parseLong(req.getParameter("smob"));
		IssueBookBean bean = new IssueBookBean(bookcallno, studentid, studentname, studentmobile);
	}
}
