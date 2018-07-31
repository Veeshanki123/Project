package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

import BO.Sign_Up;
import DAO.Sign_UpDAO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet2")
public class MainServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Sign_UpDAO Sign_UpDAO = null;
	
	@Resource(name="oracledb")
    public static DataSource dataSource;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Sign_UpDAO.dataSource=this.dataSource;
	System.out.println("request received");
	List<Sign_Up> list=Sign_UpDAO.getAllSign_Ups();
	if(list.size()!=0)
	{
		GsonBuilder gsonBuilder=new GsonBuilder();
		Gson gson=gsonBuilder.create();
		String jsonString=gson.toJson(list);
		response.getWriter().print(jsonString);
	}
		/*	Sign_UpDAO.dataSource=this.dataSource;
			Sign_Up log=new Sign_Up(2,"urvashi","urvashi","uvh@gmail.com",95679974);
			int i=Sign_UpDAO.addSign_Up(log);
			if(i>0)
				System.out.println("Record added");
			else
				System.out.println("Record not added");*/
			
	/*	Sign_Up log1=Sign_UpDAO.getSign_Up(1);
		System.out.println(log1);*/
		
		/*List<Sign_Up> list=Sign_UpDAO.getAllSign_Ups();
		if(list.size()!=0)
			System.out.println(list);*/

	 /* Sign_Up log=new Sign_Up(1,"Veeshi","veeshg",vees@gmail.com,9457988920);
		boolean i=Sign_UpDAO.UpdateSign_Up(log);
		if(i)
			System.out.println("Record Updated");
		else
			System.out.println("Record not updated");*/
		
		/*Sign_Up log=new Sign_Up(2);
		boolean i=Sign_UpDAO.DeleteSign_Up(log);
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
		Sign_UpDAO.dataSource=this.dataSource;
		InputStreamReader reader=new InputStreamReader(request.getInputStream());
		BufferedReader br=new BufferedReader(reader);
		String jsonString=br.readLine();
		System.out.println(jsonString);
		
		Gson gson=new Gson();
		Sign_Up log=gson.fromJson(jsonString,Sign_Up.class);
		int i=Sign_UpDAO.addSign_Up(log);
		if(i>0)
			System.out.println("Record added");
		else
			System.out.println("Record not added");

}}
