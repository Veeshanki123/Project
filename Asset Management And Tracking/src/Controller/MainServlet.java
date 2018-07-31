package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import BO.Asset_Type;
import DAO.Asset_TypeDAO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="oracledb")
    public static DataSource dataSource;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Asset_TypeDAO.dataSource=this.dataSource;
		/*Asset_Type ast=new Asset_Type(3,"Fans");
		int i=Asset_TypeDAO.addAsset_Type(ast);
		if(i>0)
			System.out.println("Record added");
		else
			System.out.println("Record not added");*/
			
		/*Asset_Type ast1=Asset_TypeDAO.getAsset_Type(2);
		System.out.println(ast1);*/
		
		/*List<Asset_Type> list=Asset_TypeDAO.getAllAsset_Types();
		if(list.size()!=0)
			System.out.println(list);*/
		
		/*Asset_Type ast=new Asset_Type(2,"Laptops");
		boolean i=Asset_TypeDAO.UpdateAsset_Type(ast);
		if(i)
			System.out.println("Record Updated");
		else
			System.out.println("Record not updated");*/
		
		Asset_Type ast=new Asset_Type(3);
		boolean i=Asset_TypeDAO.DeleteAsset_Type(ast);
		if(i)
			System.out.println("Record Deleted");
		else
			System.out.println("Record not deleted");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
