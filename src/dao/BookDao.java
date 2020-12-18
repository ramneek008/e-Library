package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.BookBean;

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

}
