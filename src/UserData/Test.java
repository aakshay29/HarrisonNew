package UserData;

import java.util.List;

import model.Harrisoninstructor;
import model.Harrisonstudent;

public class Test {

	public static void main(String[] args) {
		List<Harrisonstudent> harrisonstudents;
		Harrisoninstructor harrisoninstructor = ManageInstructor.getInstructor(205);
		harrisonstudents = ManageStudent.students(harrisoninstructor, "Spring2016");
		for(Harrisonstudent harrisonstudent:harrisonstudents){
			System.out.println(harrisonstudent.getStudentid());
		}
	}

}
