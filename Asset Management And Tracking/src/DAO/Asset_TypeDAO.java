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

import BO.Asset_Type;

	public class Asset_TypeDAO {
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

	public static int addAsset_Type(Asset_Type ast){
		//Insert Operation
		Connection con=getConnection();
		String sql="insert into Asset_Type values(?,?)";
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
		
		ps.setInt(1,ast.getAsset_Type_Id());
		ps.setString(2,ast.getAsset_Type_Name());
	   int result=ps.executeUpdate();
	   return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static Asset_Type getAsset_Type(int Asset_Type_Id)
	{
		Asset_Type ast=null;
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs;
		con=getConnection();
		String sql="select Asset_Type_Id,Asset_Type_Name from Asset_Type where Asset_Type_Id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,Asset_Type_Id);
		rs=ps.executeQuery();
		if(rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			ast=new Asset_Type(id,name);
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
	
	public static List<Asset_Type> getAllAsset_Types()
	{
		List<Asset_Type> list=new ArrayList<>();
		PreparedStatement ps=null;
		Connection con=null;
		Asset_Type ast=null;
		con=getConnection();
		String sql="select Asset_Type_Id,Asset_Type_Name from Asset_Type";
		try {
			ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while (rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
		
		ast=new Asset_Type(id,name);
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
	
	public static boolean UpdateAsset_Type(Asset_Type ast)
	{
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		String sql="update Asset_Type set Asset_Type_Name=? where Asset_Type_Id=?";
		try {
			ps=con.prepareStatement(sql);
			//ps.setInt(1,ast.getAsset_Type_Id());
		    ps.setString(1, ast.getAsset_Type_Name());
		    ps.setInt(2,ast.getAsset_Type_Id());
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

    public static boolean DeleteAsset_Type(Asset_Type ast)
    {
    	PreparedStatement ps=null;
    	Connection con=null;
    	String sql="delete from Asset_Type where Asset_Type_Id=?";
    	con=getConnection();
    	try {
			ps=con.prepareStatement(sql);
    	ps.setInt(1,ast.getAsset_Type_Id());
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
