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
			PreparedStatement ps = con.prepareStatement("select HR.SEQ_LIBRARIAN_ID.NEXTVAL from dual");
			ResultSet rs = ps.executeQuery();
			int id=0;
			if(rs.next())
			{
				id = rs.getInt(1);
			}
			ps = con.prepareStatement("insert into HR.E_LIBRARIAN values(?,?,?,?,?)");
			ps.setInt(1,id);
			ps.setString(2,bean.getName());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getPassword());
			ps.setLong(5, bean.getMobile());
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
			PreparedStatement ps = con.prepareStatement("update HR.E_LIBRARIAN set name = ?, email = ?, password = ?, mobile = ? where id = ?");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getPassword());
			ps.setLong(4, bean.getMobile());
			ps.setInt(5, bean.getId());
			status = ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static ArrayList<LibrarianBean> view()
	{
		ArrayList<LibrarianBean> list = new ArrayList<LibrarianBean>();
		try {
			Connection con = DBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from HR.E_LIBRARIAN");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				long mobile = rs.getLong("mobile");
				LibrarianBean bean = new LibrarianBean(id, name, email, password, mobile);
				list.add(bean);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public static int delete(int id)
	{
		int status=0;
		try {
			Connection con = DBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from HR.E_LIBRARIAN where id = ?");
			ps.setInt(1, id);
			status=ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static LibrarianBean viewById(int id)
	{
		LibrarianBean bean = new LibrarianBean();
		try {
			Connection con = DBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from HR.E_LIBRARIAN where id = ? ");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setMobile(rs.getLong(5));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return bean;
	}
}
