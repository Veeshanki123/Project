package DAO;


	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import javax.sql.DataSource;

//	import org.apache.tomcat.jdbc.pool.DataSource;


	import BO.Department;

	public class DepartmentDAO {
	public static DataSource dataSource;
	private static Connection getConnection()
	{
		Connection con=null;
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	private static void CloseConnection(Connection con) {
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static int addDepartment(Department dep)
	{
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		String sql="insert into Department values(?,?)";
		try {
			ps=con.prepareStatement(sql);
		
		ps.setInt(1,dep.getDept_Id());
		ps.setString(2,dep.getDept_Name());
		int result=ps.executeUpdate();
		return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			CloseConnection(con);
		}
		return 0;
		}

	public static Department getDepartment(int Dept_Id)
	{
		Department dep=null;
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs;
		con=getConnection();
		String sql="select Dept_Id,Dept_Name from Department where Dept_Id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,Dept_Id);
		rs=ps.executeQuery();
		if(rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			dep=new Department(id,name);
		}
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			CloseConnection(con);
		}
		return dep;
	}

	public static List<Department> getAllDepartments()
	{
		List<Department> list=new ArrayList<>();
		PreparedStatement ps=null;
		Connection con=null;
		Department dep=null;
		con=getConnection();
		String sql="select Dept_Id,Dept_Name from Department";
		try {
			ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while (rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
		
		dep=new Department(id,name);
		list.add(dep);
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

	public static boolean Department(Department dep)
	{
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		String sql="update Department set Dept_Name=? where Dept_Id=?";
		try {
			ps=con.prepareStatement(sql);
			//ps.setInt(1,ast.getAsset_Type_Id());
		    ps.setString(1, dep.getDept_Name());
		    ps.setInt(2,dep.getDept_Id());
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

	public static boolean DeleteDepartment(Department dep)
	{
		PreparedStatement ps=null;
		Connection con=null;
		String sql="delete from Department where Dept_Id=?";
		con=getConnection();
		try {
			ps=con.prepareStatement(sql);
		ps.setInt(1,dep.getDept_Id());
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

