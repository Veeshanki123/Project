package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.sql.DataSource;

import BO.Sign_Up;


	public class Sign_UpDAO {
	public static DataSource dataSource;
	private static  Connection getConnection() {
		Connection con=null;
		try {
		return dataSource.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		}

	private static void CloseConnection(Connection con)
	{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static int addSign_Up(Sign_Up sig){
		//Insert Operation
		Connection con=getConnection();
		String sql="insert into Sign_Up values(?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
		
		ps.setInt(1,sig.getUser_Id());
		ps.setString(2,sig.getUser_Name());
		ps.setString(3,sig.getUser_Password());
		ps.setString(4,sig.getEmail());
		ps.setLong(5,sig.getPhone_Number());
	   int result=ps.executeUpdate();
	   return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static Sign_Up getSign_Up(int User_Id)
	{
		Sign_Up log=null;
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs;
		con=getConnection();
		String sql="select User_Id,User_Name,User_Password,Email,Phone_Number from Sign_Up where User_Id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,User_Id);
		rs=ps.executeQuery();
		if(rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String password=rs.getString(3);
			String email=rs.getString(3);
			Long phone=rs.getLong(3);
			log=new Sign_Up(id,name,password,email,phone);
		}
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			CloseConnection(con);
		}
		return log;
	}
	
	public static List<Sign_Up> getAllSign_Ups()
	{
		List<Sign_Up> list=new ArrayList<>();
		PreparedStatement ps=null;
		Connection con=null;
		Sign_Up log=null;
		con=getConnection();
		String sql="select User_Id,User_Name,User_Password,Email,Phone_Number from Sign_Up";
		try {
			ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while (rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String password=rs.getString(3);
			String email=rs.getString(4);
			long phone=rs.getLong(5);
		
		log=new Sign_Up(id,name,password,email,phone);
		list.add(log);
		}
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseConnection(con);
		}
		return list;
	}
	
	public static boolean UpdateSign_Up(Sign_Up log)
	{
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		String sql="update Sign_Up set User_Name=? ,User_Password=?,Email=?,Phone_Number=? where User_Id=?";
		try {
			ps=con.prepareStatement(sql);
		    ps.setString(1,log.getUser_Name());
		    ps.setString(2, log.getUser_Password());
		 ps.setString(3, log.getEmail());
		   ps.setLong(4, log.getPhone_Number());
		   ps.setInt(5, log.getUser_Id());
		int i=ps.executeUpdate();
		if(i>0)
		return true;
		else
			return false;
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		CloseConnection(con);
	}
		return false;
	}

    public static boolean DeleteSign_Up(Sign_Up log)
    {
    	PreparedStatement ps=null;
    	Connection con=null;
    	String sql="delete from Sign_Up where User_Id=?";
    	con=getConnection();
    	try {
			ps=con.prepareStatement(sql);
    	ps.setInt(1,log.getUser_Id());
    	int i=ps.executeUpdate();
    	if(i>0)
    		return true;
    	else
    		return false;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
    	{
			CloseConnection(con);
    	}
    	return false;
    }
     
    }
