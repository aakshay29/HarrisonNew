
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

		List<Harrisonenrollment> harrisonenrollments;
		for (int i = 1; i < 100; i++) {
			Harrisoninstructor harrisoninstructor = ManageInstructor.getInstructor(i);
			if (harrisoninstructor != null) {
				System.out.println("Instructor-->" + harrisoninstructor.getInstructorid());
				harrisonenrollments = ManageEnrollment.enrollmentByInstructor(harrisoninstructor, "Fall2016");
				for (Harrisonenrollment harrisonenrollment : harrisonenrollments) {

					System.out.println(harrisonenrollment.getGrade());
				}
			}
		}
		System.out.println("-----------------");
		 
		Harrisonstudent harrisonstudent = ManageStudent.getStudent(105);
		Harrisonclass harrisonclass = ManageClass.getClass(281);
		System.out.println("---->>>"+ ManageEnrollment.enrollmentByStudentClass(harrisonstudent, harrisonclass).getEnrollmentid());
	}

}
