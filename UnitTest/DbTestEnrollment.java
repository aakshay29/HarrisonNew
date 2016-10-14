
import java.util.List;

import org.junit.Test;

import UserData.ManageEnrollment;
import UserData.ManageInstructor;
import model.Harrisonenrollment;
import model.Harrisoninstructor;

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

	}

}
