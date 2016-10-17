

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Harrisonclass;
import model.Harrisonuser;


/**
 * Servlet implementation class MailServlet
 */
@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("i am here");
		HttpSession session = request.getSession();
		String action =request.getParameter("action");
		System.out.println(action);
		Harrisonuser user= (Harrisonuser) session.getAttribute("user");
		
		

			String firstname=user.getName();
			String email= user.getEmail();
			session.setAttribute("email", email);
			
		
			String to =email;
			String from ="Harrison.com";
			String subject="Welcome to our email list";
			
			List <Harrisonclass> lect= (List<Harrisonclass>) session.getAttribute("lectures");
			
			 for(Harrisonclass s : lect) {
	            System.out.println(s.getClassroom());
	            System.out.println(s.getSchedule());
	        }
			String body ="Dear "+firstname +",\n\n"+"Thanks for you for shopping with. Your order is confimed and will be shipped to you within next 2 days\n\n";
			boolean isBodyHTML=false;
			System.out.println(isBodyHTML);
			
				try {
					
					JavaMail.sendMail(to, from, subject, body, isBodyHTML);
					System.out.println(body);
				} catch (javax.mail.MessagingException e) {
					// TODO Auto-generated catch block
					String errorMessage="Error: Unable to send message";
				}
				
				String nextURL="/OrderConfirmation.jsp";
				response.sendRedirect(request.getContextPath() + nextURL);
				
		}
}



