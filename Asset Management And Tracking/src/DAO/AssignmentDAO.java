package DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.sql.DataSource;

import BO.Assignment;

	public class AssignmentDAO {
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

	public static int addAssignment(Assignment as){
		//Insert Operation
		Connection con=getConnection();
		String sql="insert into Assignment values(?,?,?,?,?)";
		int result=0;
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
		
		ps.setInt(1,as.getAssignment_Id());
		ps.setDate(2,as.getAssignment_Date());
		ps.setInt(3,as.getDept_Id());
		ps.setInt(4,as.getLocation_Id());
		ps.setString(5,as.getModel_No());
	   result=ps.executeUpdate();
	   return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static Assignment getAssignment(int Assignment_Id)
	{
		Assignment as=null;
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs;
		con=getConnection();
		String sql="select Assignment_Id,Assignment_Date,Dept_Id,Location_Id,Model_No from Assignment where Assignment_Id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,Assignment_Id);
		rs=ps.executeQuery();
		if(rs.next())
		{
			int id=rs.getInt(1);
			Date date=rs.getDate(2);
			int dept=rs.getInt(3);
			int loc=rs.getInt(4);
			String mod=rs.getString(5);
			as=new Assignment(id,date,dept,loc,mod);
		}
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			CloseConnection(con);
		}
		return as;
	}
	
	public static List<Assignment> getAllAssignments()
	{
		List<Assignment> list=new ArrayList<>();
		PreparedStatement ps=null;
		Connection con=null;
		Assignment as=null;
		con=getConnection();
		String sql="select Assignment_Id,Assignment_Date,Dept_Id,Location_Id,Model_No from Assignment";
		try {
			ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while (rs.next())
		{
			int id=rs.getInt(1);
			Date date=rs.getDate(2);
			int dept=rs.getInt(3);
			int loc=rs.getInt(4);
			String mod=rs.getString(5);
		
		as= new Assignment(id,date,dept,loc,mod);
		list.add(as);
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
	
	public static boolean UpdateAdmin_Login(Assignment as)
	{
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		String sql="update Assignment set Assignment_Date=?,Dept_Id=?,Location_Id=?,Model_No=? where Assignment_Id=?";
		try {
			ps=con.prepareStatement(sql);
		    ps.setInt(1, as.getAssignment_Id());
		    ps.setDate(2,as.getAssignment_Date());
		    ps.setInt(3,as.getDept_Id());
		    ps.setInt(4,as.getLocation_Id());
		    ps.setString(5,as.getModel_No());
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

    public static boolean DeleteAssignment(Assignment as)
    {
    	PreparedStatement ps=null;
    	Connection con=null;
    	String sql="delete from Assignment where Assignment_Id=?";
    	con=getConnection();
    	try {
			ps=con.prepareStatement(sql);
    	ps.setInt(1,as.getAssignment_Id());
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
