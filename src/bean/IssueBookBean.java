package bean;

import java.sql.Date;

public class IssueBookBean {

	private String callno, studentid, studentname;
	private long studentmobile;
	private Date issueddate;
	private String returnstatus;
	
	public IssueBookBean() {}
	
	public IssueBookBean(String callno, String studentid, String studentname, long studentmobile)
	{
		this.callno = callno;
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentmobile = studentmobile;
	}
	
	public String getcallno() {
		return callno;
	}
	public void setcallno(String callno) {
		this.callno = callno;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public long getStudentmobile() {
		return studentmobile;
	}
	public void setStudentmobile(long studentmobile) {
		this.studentmobile = studentmobile;
	}
	public Date getIssueddate() {
		return issueddate;
	}
	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}
	public String getReturnstatus() {
		return returnstatus;
	}
	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}
	
	
}
