package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.BookBean;
import bean.IssueBookBean;

public class BookDao {
	
	public static int add(BookBean bean)
	{
		int status=0;
		try {
			Connection con = DBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into HR.E_BOOK values(?,?,?,?,?,?)");
			ps.setString(1, bean.getCallno());
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getAuthor());
			ps.setString(4, bean.getPublisher());
			ps.setInt(5, bean.getQuantity());
			ps.setInt(6, 0);
			status=ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;		
	}
	
	public static ArrayList<BookBean> view()
	{
		ArrayList<BookBean> list = new ArrayList<BookBean>();
		try {
			Connection con = DBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from HR.E_BOOK");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				BookBean bean = new BookBean();
				bean.setCallno(rs.getString("callno"));
				bean.setName(rs.getString("name"));
				bean.setAuthor(rs.getString("author"));
				bean.setPublisher(rs.getString("publisher"));
				bean.setQuantity(rs.getInt("quantity"));
				bean.setIssued(rs.getInt("issued"));
				list.add(bean);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return list;	
	}
	
	public static int delete(String callno)
	{
		int status = 0;
		try {
			Connection con = DBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from HR.E_BOOK where callno = ?");
			ps.setString(1, callno);
			status = ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static boolean checkIssue(String callno)
	{
		boolean status=false;
		try {
			Connection con = DBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from HR.E_BOOK where callno = ? and quantity>issued");
			ps.setString(1, callno);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				status=true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int issueCount(String callno)
	{
		int issued = 0;
		try {
			Connection con = DBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from HR.E_BOOK where callno = ?");
			ps.setString(1, callno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				issued = rs.getInt("issued");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return issued;
	}
	
	public static int issueBook(IssueBookBean bean)
	{
		String callno = bean.getcallno();
		boolean checkstatus = checkIssue(callno);
		if(checkstatus)
		{
			int status = 0;
			try {
				Connection con = DBConnectivity.getConnection();
				PreparedStatement ps = con.prepareStatement("insert into HR.E_ISSUEBOOK values(?,?,?,?,?,?)");
				ps.setString(1, bean.getcallno());
				ps.setString(2, bean.getStudentid());
				ps.setString(3, bean.getStudentname());
				ps.setLong(4, bean.getStudentmobile());
				java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
				ps.setDate(5, currentDate);
				ps.setString(6, "No");
				status=ps.executeUpdate();
				
				if(status == 1) {
					PreparedStatement ps2 = con.prepareStatement("update HR.E_BOOK set issued = ? where callno = ?");
					ps2.setInt(1, issueCount(callno)+1);
					ps2.setString(2, callno);
					status=ps.executeUpdate();
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return status;
		}
		else
			return 0;
		
	}

}
