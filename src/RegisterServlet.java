

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Harrisoninstructor;
import model.Harrisonstudent;
import model.Harrisonuser;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
	
		String role =request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		
		Harrisonuser newuser=new Harrisonuser();
		
		if(role.equalsIgnoreCase("student")){
			float student=1;
			String major= request.getParameter("Major");
			String year=request.getParameter("Enrollment Year");
			
			
			newuser.setName(name);
			newuser.setEmail(email);
			newuser.setPassword(password);
			newuser.setRole(student);
			DBManageUser.adduser(newuser);
			
			Harrisonuser user =DBManageUser.isValidUser(email,password);
			Harrisonstudent stud =new Harrisonstudent();
			
			stud.setHarrisonuser(user);
			stud.setMajor(major);
			stud.setYearofentry(Float.parseFloat(year));
			System.out.println("Student Record Inserted");
			
		}
		else if(role.equalsIgnoreCase("Instructor")){
			float instructor=2;
			String department=request.getParameter("Department");
			String officenumber= request.getParameter("officenumber");
			newuser.setName(name);
			newuser.setEmail(email);
			newuser.setPassword(password);
			newuser.setRole(instructor);
			DBManageUser.addUser(newuser);
			
			Harrisonuser user =DBManageUser.isValidUser(email,password);
			Harrisoninstructor inst= new Harrisoninstructor();
			inst.setHarrisonuser(user);
			inst.setOfficenumber(Float.parseFloat(officenumber));
			inst.setDepartment(department);
			DBManageInstructor.add(inst);
			System.out.println("Student Record Inserted");
			
			
		}
	}

}
