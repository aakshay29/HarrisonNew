

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UserData.ManageInstructor;
import UserData.ManageStudent;
import UserData.ManageUser;
import model.Harrisoninstructor;
import model.Harrisonstudent;
import model.Harrisonuser;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String nextURL = "";	
		String action = request.getParameter("action");	
		int userID = Integer.parseInt(request.getParameter("userid"));	
		Harrisonuser user = ManageUser.getUser(userID);
		session.setAttribute("user", user);
		int role = user.getRole().intValue();
		if(action.equalsIgnoreCase("update")){
			if(role == 2){
				Harrisoninstructor instructor = ManageInstructor.getInstructor(user);			
				session.setAttribute("instructor", instructor);
				nextURL="/UpdateInstructor.jsp";
			}
			else if(role == 3){
				Harrisonstudent student = ManageStudent.getStudentFromUserid(user);
				session.setAttribute("student", student);
				nextURL="/UpdateStudent.jsp";
			}
		}
		else if(action.equalsIgnoreCase("switchRole")){
			if(role == 2){
				Harrisoninstructor instructor = ManageInstructor.getInstructor(user);	
				ManageInstructor.delete(instructor);
				Harrisonstudent student = null;
				session.setAttribute("student", student);
				nextURL="/UpdateStudent.jsp";
			}
			else if(role == 3){
				Harrisonstudent student = ManageStudent.getStudentFromUserid(user);
				ManageStudent.delete(student);
				Harrisoninstructor instructor = null;
				session.setAttribute("instructor", instructor);
				nextURL="/UpdateInstructor.jsp";
			}
		}
		else if(action.equalsIgnoreCase("updateInstructor")){
			String department = "";
			BigDecimal officenumber = null;
			Harrisoninstructor instructor = new Harrisoninstructor();
			instructor.setDepartment(department);
			instructor.setHarrisonuser(user);
			instructor.setOfficenumber(officenumber);
			ManageInstructor.update(instructor);
			nextURL="/admin.jsp";
		}
		else if(action.equalsIgnoreCase("updateStudent")){
			String major = "";
			BigDecimal yearofentry = null;
			Harrisonstudent student = new Harrisonstudent();
			student.setHarrisonuser(user);
			student.setMajor(major);
			student.setYearofentry(yearofentry);
			ManageStudent.update(student);
			nextURL="/admin.jsp";
		}
		else if(action.equalsIgnoreCase("switchToStudent")){
			String major = "";
			BigDecimal yearofentry = null;
			Harrisonstudent student = new Harrisonstudent();
			student.setHarrisonuser(user);
			student.setMajor(major);
			student.setYearofentry(yearofentry);
			ManageStudent.addStudent(student);
			nextURL="/admin.jsp";
		}
		else if(action.equalsIgnoreCase("switchToInstructor")){
			String department = "";
			BigDecimal officenumber = null;
			Harrisoninstructor instructor = new Harrisoninstructor();
			instructor.setDepartment(department);
			instructor.setHarrisonuser(user);
			instructor.setOfficenumber(officenumber);
			ManageInstructor.addInstructor(instructor);
			nextURL="/admin.jsp";
		}
		response.sendRedirect(request.getContextPath() + nextURL);	
	}

}
