package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.LibrarianBean;

public class LibrarianDao {
	
	public static int add(LibrarianBean bean)
	{
		int status=0;
		try {
			Connection con = DBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into HR.E_LIBRARIAN values(?,?,?,?)");
			ps.setString(1,bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getPassword());
			ps.setLong(4, bean.getMobile());
			status=ps.executeUpdate();			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;	
	}
	
	public static int edit(LibrarianBean bean)
	{
		int status=0;
		try {
			Connection con = DBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("update HR.E_LIBRARIAN set name = ?, password = ?, mobile = ? where email = ?");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getPassword());
			ps.setLong(3, bean.getMobile());
			ps.setString(4, bean.getEmail());
			status = ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static ArrayList<LibrarianBean> view(){
		ArrayList<LibrarianBean> list = new ArrayList<LibrarianBean>();
		try {
			Connection con = DBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from HR.E_LIBRARIAN");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				long mobile = rs.getLong("mobile");
				LibrarianBean bean = new LibrarianBean(name, email, password, mobile);
				list.add(bean);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
