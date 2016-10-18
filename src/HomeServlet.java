

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.mail.MessagingException;
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextURL = "";
		HttpSession session = request.getSession();
		Harrisonstudent student = (Harrisonstudent) session.getAttribute("student");
		String action = request.getParameter("action");	
		if(action.equalsIgnoreCase("drop")){
			System.out.println("Drop......");
			int enID = Integer.parseInt(request.getParameter("enrollmentid"));	
			Harrisonenrollment enrollment = ManageEnrollment.getEnrollment(enID);
			ManageEnrollment.delete(enrollment);		
			nextURL = "/HomeStudent.jsp";
		}
		else if(action.equalsIgnoreCase("enroll")){
			System.out.println("Enroll......");
			int classid = Integer.parseInt(request.getParameter("classid"));	
			Harrisonenrollment en = new Harrisonenrollment();
			en.setHarrisonclass(ManageClass.getClass(classid));
			en.setHarrisonstudent(student);
			en.setStatus(ManageClass.getClass(classid).getStatus());
			ManageEnrollment.insert(en);
			nextURL = "/HomeStudent.jsp";
		}
		else if(action.equalsIgnoreCase("Transcript")){
			System.out.println("Transcript......");
			List <Harrisonenrollment> enrollmentlist2 = student.getHarrisonenrollments();
			try {
				JavaMail.sendMail("aakshay@gmail.com", "aakshay@gmail.com", "Transcripts", enrollmentlist2.toString(), true);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			nextURL = "/HomeStudent.jsp";
		}		
		List <Harrisonenrollment> enrollmentlist = student.getHarrisonenrollments();
		session.setAttribute("enrollmentlist", enrollmentlist);
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
