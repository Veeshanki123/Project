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
import BO.Location;

	public class LocationDAO {
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

	public static int addLocation(Location loc){
		//Insert Operation
		Connection con=getConnection();
		String sql="insert into Location values(?,?)";
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
		
		ps.setInt(1,loc.getLocation_Id());
		ps.setString(2,loc.getLocation_Name());
	   int result=ps.executeUpdate();
	   return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static Location getLocation(int Location_Id)
	{
		Location loc=null;
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs;
		con=getConnection();
		String sql="select Location_Id,Location_Name from Location where Location_Id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,Location_Id);
		rs=ps.executeQuery();
		if(rs.next())
		{
			int id=rs.getInt(1);
			System.out.println(id);
			String name=rs.getString(2);
			loc=new Location(id,name);
		}
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			CloseConnection(con);
		}
		return loc;
	}
	
	public static List<Location> getAllLocations()
	{
		List<Location> list=new ArrayList<>();
		PreparedStatement ps=null;
		Connection con=null;
		Location loc=null;
		con=getConnection();
		String sql="select Location_Id,Location_Name from Location";
		try {
			ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while (rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
		
		loc=new Location(id,name);
		list.add(loc);
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
	
	public static boolean UpdateLocation(Location loc)
	{
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		String sql="update Location set Location_Name=? where Location_Id=?";
		try {
			ps=con.prepareStatement(sql);
		    ps.setString(1,loc.getLocation_Name());
		    ps.setInt(2, loc.getLocation_Id());
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

    public static boolean DeleteLocation(Location loc)
    {
    	PreparedStatement ps=null;
    	Connection con=null;
    	String sql="delete from Location where Location_Id=?";
    	con=getConnection();
    	try {
			ps=con.prepareStatement(sql);
    	ps.setInt(1,loc.getLocation_Id());
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
