package Controller;
import DAO.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import BO.Assignment;
import DAO.AssignmentDAO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet5")
public class MainServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final AssignmentDAO AssignmentDAO = null;
	@Resource(name="oracledb")
    public static DataSource dataSource;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AssignmentDAO.dataSource=this.dataSource;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			Assignment as=null;
			
			try {
				as = new Assignment(2,new java.sql.Date(sdf.parse("23-04-2018").getTime()),89,9, "AS12");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(as);
		int	i=AssignmentDAO.addAssignment(as);
			if(i>0)
				System.out.println("Record added");
			else
				System.out.println("Record not added");
			
	/*	Assignment as1=AssignmentDAO.getAssignment(1);
		System.out.println(as1);*/
		
		/*List<Assignment> list=AssignmentDAO.getAllAssignments();
		if(list.size()!=0)
			System.out.println(list);*/

	 /* Assignment as=new Assignment(1,12/12/18,12,11,fr54);
		boolean i=AssignmentDAO.UpdateAssignment(as);
		if(i)
			System.out.println("Record Updated");
		else
			System.out.println("Record not updated");*/
		
		/*Assignment as=new Assignment(2);
		boolean i=AssignmentDAO.DeleteAssignment(as);
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
