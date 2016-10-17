

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UserData.ManageCourse;
import UserData.ManageInstructor;
import UserData.ManageStudent;
import UserData.ManageUser;
import model.Harrisonuser;
import model.Harrisoncourse;
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
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Harrisonuser user=ManageUser.isValidUser(email,password);
		
		if(user !=null){
			System.out.println("The user is valid");
			session.setAttribute("user", user);
			nextURL="/Home.jsp";
		}
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
