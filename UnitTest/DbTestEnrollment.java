
import java.util.List;

import org.junit.Test;

import UserData.ManageClass;
import UserData.ManageEnrollment;
import UserData.ManageInstructor;
import UserData.ManageStudent;
import model.Harrisonclass;
import model.Harrisonenrollment;
import model.Harrisoninstructor;
import model.Harrisonstudent;

public class DbTestEnrollment {

	@Test
	public void test() {

		Harrisonstudent harrisonstudent = ManageStudent.getStudent(164);
		Harrisonclass harrisonclass = ManageClass.getClass(280);
		System.out.println("---->>>"+ ManageEnrollment.gradeByStudentCoursename(harrisonstudent, "business"));
//		String s = ""; 
//		s= ManageEnrollment.gradeByStudentCoursename(harrisonstudent, "das");
//		System.out.println("------"+s);
//		if(s==null){
//			System.out.println("null");
//		}
	}

}
