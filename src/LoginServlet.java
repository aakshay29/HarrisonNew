

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
import UserData.ManageInstructor;
import UserData.ManageStudent;
import UserData.ManageUser;
import model.Harrisonuser;
import model.Harrisonclass;
import model.Harrisoncourse;
import model.Harrisonenrollment;
import model.Harrisoninstructor;
import model.Harrisonstudent;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String nextURL="";
		List <Harrisonclass> classList = null;
		List <Harrisonenrollment> enrollmentlist = null;
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Harrisonuser user=ManageUser.isValidUser(email,password);
		
		classList = ManageClass.classes();
		session.setAttribute("classList", classList);
		//System.out.println(classList.get(0).harrisoncourse.coursename);
		
		if(user !=null){	
			session.setAttribute("user", user);
			int role = user.getRole().intValue();
			System.out.println("rollee: " + Integer.parseInt(user.getRole().toString()));
			
			if(role == 1){
<<<<<<< HEAD
				System.out.println("*********one*********");
				Harrisonuser admin = ManageUser.getUserByEmail(user.getEmail());
				session.setAttribute("admin", admin);
				session.setAttribute("enrollmentlist", enrollmentlist);
				nextURL="/admin.jsp";
=======
				List <Harrisonuser> userList = ManageUser.getUserList();
				session.setAttribute("userList", userList);
				nextURL="/Login.jsp";
>>>>>>> 2584907865fa7dbaa73500a797427d1e169aec47
			}
			else if(role == 2){
				System.out.println("two");
				Harrisoninstructor inst = ManageInstructor.getInstructor(user);
				session.setAttribute("inst", inst);
				nextURL="/InstructorStart.jsp";
			}
			else if(role == 3){
				System.out.println("three");
				Harrisonstudent student = ManageStudent.getStudentFromUserid(user);
				session.setAttribute("student", student);
				enrollmentlist = student.getHarrisonenrollments();
				session.setAttribute("enrollmentlist", enrollmentlist);
				//request.getSession().setAttribute("enrollmentList", enrollmentList);
				nextURL="/HomeStudent.jsp";
			}
			else{
				System.out.println("none");
				nextURL="/Login.jsp";
			}
		}
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
