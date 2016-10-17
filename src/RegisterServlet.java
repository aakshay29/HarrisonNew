

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserData.ManageInstructor;
import UserData.ManageUser;
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
		
	
		String role =request.getParameter("check");
		System.out.println("role :" + role);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		
		Harrisonuser newuser=new Harrisonuser();
		
		if(role.equalsIgnoreCase("student")){
			BigDecimal student= new BigDecimal(1);
			System.out.println("studentrole: "+student);
			
			String major= request.getParameter("major");
			System.out.println("major: "+major);
			
			String year=request.getParameter("year");
			int yr =Integer.parseInt(year);
			System.out.println("year: "+year);
			
			BigDecimal enyear= new BigDecimal (yr);
			System.out.println("year: "+enyear);
			
			newuser.setName(name);
			newuser.setEmail(email);
			newuser.setPassword(password);
			newuser.setRole(student);
			ManageUser.insert(newuser);
			
			Harrisonuser user =ManageUser.isValidUser(email,password);
			Harrisonstudent stud =new Harrisonstudent();
			
			stud.setHarrisonuser(user);
			stud.setMajor(major);
			stud.setYearofentry(enyear);
			System.out.println("Student Record Inserted");
			
		}
		else if(role.equalsIgnoreCase("Instructor")){
			BigDecimal instructor= new BigDecimal (2);
			String department=request.getParameter("Department");
			String officenumber= request.getParameter("officenumber");
			int offnumber=Integer.parseInt(officenumber);
			BigDecimal office= new BigDecimal (offnumber);
			
			newuser.setName(name);
			newuser.setEmail(email);
			newuser.setPassword(password);
			newuser.setRole(instructor);
			ManageUser.insert(newuser);
			
			Harrisonuser user =ManageUser.isValidUser(email,password);
			Harrisoninstructor inst= new Harrisoninstructor();
			inst.setHarrisonuser(user);
			inst.setOfficenumber(office);
			inst.setDepartment(department);
			ManageInstructor.addInstructor(inst);
			System.out.println("Student Record Inserted");
			
			
		}
	}

}
