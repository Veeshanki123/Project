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

import BO.Location;
import DAO.LocationDAO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet4")
public class MainServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="oracledb")
    public static DataSource dataSource;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LocationDAO.dataSource=this.dataSource;
		/*Location loc=new Location(2,"meerut");
		int i=LocationDAO.addLocation(loc);
		if(i>0)
			System.out.println("Record added");
		else
			System.out.println("Record not added");*/
			
		/*Location loc1=LocationDAO.getLocation(2);
		System.out.println(loc1);*/
		
		/*List<Location> list=LocationDAO.getAllLocations();
		if(list.size()!=0)
			System.out.println(list);*/

		Location loc2=new Location(1,"meerut");
		boolean i=LocationDAO.UpdateLocation(loc2);
		if(i)
			System.out.println("Record Updated");
		else
			System.out.println("Record not updated");
		
		/*Location loc3=new Location(2, null);
		boolean i=LocationDAO.DeleteLocation(loc3);
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
		doGet(request, response);
	}

}
