package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import BO.Asset;



public class AssetDAO {
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

	public static int addAsset(Asset ast){
		//Insert Operation
		Connection con=getConnection();
		String sql="insert into Asset values(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
		
		ps.setString(1,ast.getModel_No());
		ps.setInt(2,ast.getAsset_Type_Id());
		ps.setInt(3,ast.getDept_Id());
		ps.setInt(4,ast.getLocation_Id());
		
	   int result=ps.executeUpdate();
	   return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static Asset getAsset(int Model_No)
	{
		Asset ast=null;
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs;
		con=getConnection();
		String sql="select Model_No,Asset_Type_Id,Dept_Id,Location_Id from Asset where Model_No=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,Model_No);
		rs=ps.executeQuery();
		if(rs.next())
		{
			String no=rs.getString(1);
			int id=rs.getInt(2);
			int id1=rs.getInt(3);
			int id2=rs.getInt(4);
			
			ast=new Asset(no,id,id1,id2);
		}
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			CloseConnection(con);
		}
		return ast;
	}
	
	public static List<Asset> getAllAssets()
	{
		List<Asset> list=new ArrayList<>();
		PreparedStatement ps=null;
		Connection con=null;
		Asset ast=null;
		con=getConnection();
		String sql="select Model_No,Asset_Type_Id,Dept_Id,Location_Id from Asset";
		try {
			ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while (rs.next())
		{
			String no=rs.getString(1);
			int id=rs.getInt(2);
			int id1=rs.getInt(3);
			int id2=rs.getInt(4);
			
		
		ast=new Asset(no,id,id1,id2);
		list.add(ast);
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
	
	public static boolean UpdateAsset(Asset ast)
	{
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		String sql="update Asset set Asset_Type_Id=?,Dept_Id=?,Location_Id=? where Model_No=?";
		try {
			ps=con.prepareStatement(sql);
			//ps.setInt(1,ast.getAsset_Type_Id());
		    ps.setInt(1, ast.getAsset_Type_Id());
		    ps.setInt(2,ast.getDept_Id());
		    ps.setInt(3,ast.getLocation_Id());
		   
		    ps.setString(5,ast.getModel_No());
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

    public static boolean DeleteAsset(Asset ast)
    {
    	PreparedStatement ps=null;
    	Connection con=null;
    	String sql="delete from Asset where Model_No=?";
    	con=getConnection();
    	try {
			ps=con.prepareStatement(sql);
    	ps.setString(1,ast.getModel_No());
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
