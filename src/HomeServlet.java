

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UserData.ManageClass;
import UserData.ManageCourse;
import UserData.ManageEnrollment;
import UserData.ManageInstructor;
import UserData.ManageStudent;
import model.Harrisonclass;
import model.Harrisoncourse;
import model.Harrisonenrollment;
import model.Harrisoninstructor;
import model.Harrisonstudent;
import model.Harrisonuser;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession();
		Harrisonstudent student = (Harrisonstudent) session.getAttribute("student");
		List <Harrisonenrollment> enrollmentlist = student.getHarrisonenrollments();
		session.setAttribute("enrollmentlist", enrollmentlist);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextURL = "";
		String action = request.getParameter("action");	
		if(action.equalsIgnoreCase("drop")){
			System.out.println("Hello......");
			int enID = Integer.parseInt(request.getParameter("enrollmentid"));	
			Harrisonenrollment enrollment = ManageEnrollment.getEnrollment(enID);
			ManageEnrollment.delete(enrollment);		
			nextURL = "/HomeStudent.jsp";
		}
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
