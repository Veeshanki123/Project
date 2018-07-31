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

import BO.Asset;
import BO.Department;
import BO.Sign_Up;
import DAO.AssetDAO;
import DAO.DepartmentDAO;


/**
 * Servlet implementation class MainServlet2
 */
@WebServlet("/MainServlet3")
public class MainServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 @Resource(name="oracledb")
	 public static DataSource dataSource;




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AssetDAO.dataSource=this.dataSource;
		 System.out.println("request received");
		 	List<Asset> list=AssetDAO.getAllAssets();
		 	if(list.size()!=0)
		 	{
		 		GsonBuilder gsonBuilder=new GsonBuilder();
		 		Gson gson=gsonBuilder.create();
		 		String jsonString=gson.toJson(list);
		 		response.getWriter().print(jsonString);
		 	}
		/*Asset ast=new Asset("PS123QW5",1,12,13);
		int i=AssetDAO.addAsset(ast);
		if(i>0)
			System.out.println("Record added");
		else
			System.out.println("Record not added");*/
			
		/*Asset ast1=AssetDAO.getAsset(2);
		System.out.println(ast1);*/
		
		/*List<Asset> list=AssetDAO.getAllAssets();
		if(list.size()!=0)
			System.out.println(list);*/
		
		/*Asset ast=new Asset("PQ123VY6",2,4,6);
		boolean i=AssetDAO.UpdateAsset(ast);
		if(i)
			System.out.println("Record Updated");
		else
			System.out.println("Record not updated");*/
		
		/*Asset ast=new Asset("PW123TY");
		boolean i=AssetDAO.DeleteAsset(ast);
		if(i)
			System.out.println("Record Deleted");
		else
			System.out.println("Record not deleted");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AssetDAO.dataSource=this.dataSource;
		InputStreamReader reader=new InputStreamReader(request.getInputStream());
		BufferedReader br=new BufferedReader(reader);
		String jsonString=br.readLine();
		System.out.println(jsonString);
		
		Gson gson=new Gson();
		Asset log=gson.fromJson(jsonString,Asset.class);
		int i=AssetDAO.addAsset(log);
		if(i>0)
			System.out.println("Record added");
		else
			System.out.println("Record not added");

	}

}
