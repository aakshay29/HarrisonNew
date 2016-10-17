

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
		
//		Harrisonuser user = null;
//		HttpSession session = request.getSession();	
//		
//		user = (Harrisonuser) session.getAttribute("user");
//		List <Harrisonclass> classList = null;
//		List <Harrisonenrollment> enrollmentList = null;
//		String nextURL = "";
//
//		List<Harrisonstudent> harrisonstudents;
//		Harrisoninstructor harrisoninstructor = ManageInstructor.getInstructor(205);
//		harrisonstudents = ManageStudent.students(harrisoninstructor, "Spring2016");
//		for(Harrisonstudent harrisonstudent:harrisonstudents){
//			System.out.println(harrisonstudent.getStudentid());		
//		}
//		
//		BigDecimal one = new BigDecimal(1);
//		BigDecimal two = new BigDecimal(2);
//		BigDecimal three = new BigDecimal(3);
//		if(user.getRole() == one){
//			nextURL="/Login.jsp";
//		}
//		else if(user.getRole() == two){
//			nextURL="/Login.jsp";
//		}
//		else if(user.getRole() == three){
//			Harrisonstudent student = ManageStudent.getStudent(user.getUserid());
//			enrollmentList = student.getHarrisonenrollments();
//			session.setAttribute("enrollmentlist", enrollmentList);
//			request.getSession().setAttribute("enrollmentlist", enrollmentList);
//			nextURL="/HomeStudent.jsp";
//		}
//		else{
//			classList = ManageClass.classes();
//			session.setAttribute("classList", classList);
//			nextURL="/Login.jsp";
//		}
//		response.sendRedirect(request.getContextPath() + nextURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
