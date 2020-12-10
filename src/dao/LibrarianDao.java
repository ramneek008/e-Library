package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.LibrarianBean;

public class LibrarianDao {
	
	public static int save(LibrarianBean bean)
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
}
