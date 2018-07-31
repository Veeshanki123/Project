
	package Controller;

	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.Resource;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//import org.apache.tomcat.jdbc.pool.DataSource;


	import BO.Department;
import BO.Sign_Up;
import DAO.DepartmentDAO;

	/**
	 * Servlet implementation class MainServlet1
	 */
	@WebServlet("/MainServlet1")
	public class MainServlet1 extends HttpServlet {
		
		private static final long serialVersionUID= 2323232;
	       
			@Resource(name="oracledb")
	       public static DataSource dataSource;
	    
	       public MainServlet1() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     DepartmentDAO.dataSource=this.dataSource;
	     System.out.println("request received");
	 	List<Department> list=DepartmentDAO.getAllDepartments();
	 	if(list.size()!=0)
	 	{
	 		GsonBuilder gsonBuilder=new GsonBuilder();
	 		Gson gson=gsonBuilder.create();
	 		String jsonString=gson.toJson(list);
	 		response.getWriter().print(jsonString);
	 	}
		/*Department dep=new Department(1,"IT");
		int i=DepartmentDAO.addDepartment(dep);
		if(i>0)
			System.out.println("Record Added");
		else
			System.out.println("Record Not Added");*/
		
		/*Department dep1=DepartmentDAO.getDepartment(2);
			System.out.println(dep1);*/
			
			/*List<Department> list=DepartmentDAO.getAllDepartments();
			if(list.size()!=0)
				System.out.println(list);*/
			
			/*Department dep=new Department(2,"CSE");
			boolean i=DepartmentDAO.UpdateDepartment(dep);
			if(i)
				System.out.println("Record Updated");
			else
				System.out.println("Record not updated");*/
			

		/*Department dep2=new Department(3);
		boolean i1=DepartmentDAO.DeleteDepartment(dep2);
		if(i1)
			System.out.println("Record Deleted");
		else
			System.out.println("Record not deleted");*/
		
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			DepartmentDAO.dataSource=this.dataSource;
			InputStreamReader reader=new InputStreamReader(request.getInputStream());
			BufferedReader br=new BufferedReader(reader);
			String jsonString=br.readLine();
			System.out.println(jsonString);
			
			Gson gson=new Gson();
			Department log=gson.fromJson(jsonString,Department.class);
			int i=DepartmentDAO.addDepartment(log);
			if(i>0)
				System.out.println("Record added");
			else
				System.out.println("Record not added");
		}

	}


