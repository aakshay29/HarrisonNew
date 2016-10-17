import static org.junit.Assert.*;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Test;

import UserData.ManageCourse;
import model.Harrisoncourse;

public class ViewCourses {

	@Test
	public void test() {
		HttpSession session = request.getSession();
		List <Harrisoncourse> cr =ManageCourse.courses();
		session.setAttribute("courses", cr);
		nextURL="/ViewCourses.jsp";
		
	}

}
