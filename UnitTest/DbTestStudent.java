import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import UserData.ManageInstructor;
import UserData.ManageStudent;
import model.Harrisoninstructor;
import model.Harrisonstudent;

public class DbTestStudent {

	@Test
	public void test() {
		List<Harrisonstudent> harrisonstudents;
		for (int i = 1; i < 100; i++) {
			Harrisoninstructor harrisoninstructor = ManageInstructor.getInstructor(i);
			if(harrisoninstructor!=null){
			System.out.println("Instructor-->"+harrisoninstructor.getInstructorid());
			harrisonstudents = ManageStudent.students(harrisoninstructor, "Fall2016");
			System.out.println("Size--->" + harrisonstudents.size());
			for (Harrisonstudent harrisonstudent : harrisonstudents) {

				System.out.println(harrisonstudent.getStudentid());
			}
			}
		}
	}

}
