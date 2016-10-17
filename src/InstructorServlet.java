

import java.io.IOException;
import java.util.List;

import model.Harrisonclass;
import model.Harrisoncourse;
import model.Harrisonenrollment;
import model.Harrisoninstructor;
import model.Harrisonstudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UserData.ManageClass;
import UserData.ManageCourse;
import UserData.ManageEnrollment;
import UserData.ManageStudent;

/**
 * Servlet implementation class InstructorServlet
 */
@WebServlet("/InstructorServlet")
public class InstructorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstructorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String nextURL;
		Harrisoninstructor inst= (Harrisoninstructor) session.getAttribute("inst");
		String sem= request.getParameter("id");
		session.setAttribute("sem", sem);
		
		List <Harrisonclass> lectures= ManageClass.classes(inst, sem);
		session.setAttribute("lectures", lectures);
		nextURL="/InstructorView.jsp";
		
		response.sendRedirect(request.getContextPath() + nextURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String nextURL="";
		Harrisoninstructor inst= (Harrisoninstructor) session.getAttribute("inst");
		String sem= (String) session.getAttribute("sem");
		
		String action= request.getParameter("action");
		
		if(action.equalsIgnoreCase("StudentRoster")){
			List <Harrisonstudent> students= ManageStudent.students(inst, sem);
			session.setAttribute("students", students);
			nextURL="/StudentRoster.jsp";
			
				
		}
		
		else if(action.equalsIgnoreCase("AssignGrade")){
			String id =request.getParameter("StudentId");
			String classid =request.getParameter("Classid");
			String grade =request.getParameter("Grade");
			
			Harrisonstudent student=ManageStudent.getStudent(Long.parseLong(id));
			Harrisonclass clas=ManageClass.getClass(Long.parseLong(classid));
			
			
			
			Harrisonenrollment en= ManageEnrollment.enrollmentByStudentClass(student,clas);
			
			en.setGrade(grade);
			ManageEnrollment.update(en);
			nextURL="/StudentRoster.jsp";
			
		
		}
		
		else if(action.equalsIgnoreCase("ViewCourses")){
		List <Harrisoncourse> cr =ManageCourse.courses();
		session.setAttribute("courses", cr);
		nextURL="/ViewCourses.jsp";
		
			
		}
		
		else if(action.equalsIgnoreCase("ViewGrades")){
		List <Harrisonenrollment> hm=ManageEnrollment.enrollmentByInstructor(inst, sem);
		session.setAttribute("enroll", hm);
		nextURL="/ViewGrades.jsp";
		}
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
