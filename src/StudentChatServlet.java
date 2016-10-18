
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
 * Servlet implementation class AJAXServlet
 */
@WebServlet("/StudentChatServlet")
public class StudentChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentChatServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "";
		HttpSession session = request.getSession();
		Harrisonstudent student = (Harrisonstudent) session.getAttribute("student");
		if ("yes".equalsIgnoreCase(request.getParameter("response").toString())) {
			message = "Do you want to ask about your schedule, grade or transcript?";

		} else if ("schedule".equalsIgnoreCase(request.getParameter("response").toString())) {
			for (Harrisonenrollment enrollment : student.getHarrisonenrollments()) {
				message = enrollment.getHarrisonclass().getSchedule() + "\n";
			}
		} else if ("grade".equalsIgnoreCase(request.getParameter("response").toString())) {
			message = "Which class do you want the grade for? (Grade coursename)";
		} else if ("grade".equalsIgnoreCase(request.getParameter("response").toString().split(" ")[0])) {
			String coursename = request.getParameter("response").toString().split(" ")[1];
			String grade = ManageEnrollment.gradeByStudentCoursename(student, coursename);
			if (grade != null) {

				message = "Your grade is: " + grade;
			} else {
				message = "You have not taken that course";
			}
		} else if ("transcript".equalsIgnoreCase(request.getParameter("response").toString())) {
			Harrisonuser user = (Harrisonuser) session.getAttribute("user");
			String email = user.getEmail();
			String to = email;
			String from = "HarrisonCollege";
			String subject = "Transcript";
			String body = "";
			for (Harrisonenrollment s : student.getHarrisonenrollments()) {
				body += s.getHarrisonclass().getHarrisoncourse().getCoursename();
				body += "\t" + s.getGrade();
				body += "\n";
			}

			boolean isBodyHTML = false;

			try {

				JavaMail.sendMail(to, from, subject, body, isBodyHTML);
				System.out.println(body);
				message = "Your transcript is mailed";
			} catch (javax.mail.MessagingException e) {
				System.out.println(e);
				message = "Unable to mail transcript this time";
			}
		}
		response.setContentType("text/plain");// send plain text back to browser
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
