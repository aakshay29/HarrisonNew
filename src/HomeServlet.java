

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UserData.ManageEnrollment;
import UserData.ManageInstructor;
import UserData.ManageStudent;
import model.Harrisonclass;
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
		
		String logout = (String)request.getParameter("logout");
		if("yes".equalsIgnoreCase(logout)){
			session.setAttribute("user", null);
		}
		
		
		Harrisonuser user = null;
		
		user = (Harrisonuser) session.getAttribute("user");
		List <Harrisonclass> classList = null;
		List <Harrisonenrollment> enrollmentList = null;

		List<Harrisonstudent> harrisonstudents;
		Harrisoninstructor harrisoninstructor = ManageInstructor.getInstructor(205);
		harrisonstudents = ManageStudent.students(harrisoninstructor, "Spring2016");
		for(Harrisonstudent harrisonstudent:harrisonstudents)
		{
			System.out.println(harrisonstudent.getStudentid());
		}
		
		
		
		String nextURL = "/Home.jsp";
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
	
	

	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
