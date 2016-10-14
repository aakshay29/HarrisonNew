

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UserData.ManageEnrollment;
import model.Harrisonclass;
import model.Harrisonenrollment;
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
		Harrisonuser user = null;
		HttpSession session = request.getSession();
		user = (Harrisonuser) session.getAttribute("user");
		List <Harrisonclass> classList = null;
		List <Harrisonenrollment> enrollmentList = null;
		if(user.getName() == null){
			classList = ManageClass.classes();
			session.setAttribute("classList", classList);	
		}
		else{
			Harrisonstudent student = ManageStudent.
			enrollmentList = ManageEnrollment.enrollmentByStudent(harrisonstudent);
			session.setAttribute("enrollmentList", enrollmentList);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
