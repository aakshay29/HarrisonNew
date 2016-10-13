package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the HARRISONCLASS database table.
 * 
 */
@Entity
@NamedQuery(name = "Harrisonclass.findAll", query = "SELECT h FROM Harrisonclass h")
public class Harrisonclass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long classid;

	private String classroom;

	@Column(name = "\"SCHEDULE\"")
	private String schedule;

	private String semester;

	private BigDecimal status;

	// bi-directional many-to-one association to Harrisoncourse
	@ManyToOne
	@JoinColumn(name = "COURSEID")
	private Harrisoncourse harrisoncourse;

	// bi-directional many-to-one association to Harrisoninstructor
	@ManyToOne
	@JoinColumn(name = "INSTRUCTORID")
	private Harrisoninstructor harrisoninstructor;

	// bi-directional many-to-one association to Harrisonenrollment
	@OneToMany(mappedBy = "harrisonclass")
	private List<Harrisonenrollment> harrisonenrollments;

	public Harrisonclass() {
	}

	public Harrisonclass(Harrisoncourse harrisoncourse, Harrisoninstructor harrisoninstructor, String classroom,
			String schedule, BigDecimal status, String semester) {
		this.harrisoncourse = harrisoncourse;
		this.harrisoninstructor = harrisoninstructor;
		this.classroom = classroom;
		this.schedule = schedule;
		this.status = status;
		this.semester = semester;
	}

	public long getClassid() {
		return this.classid;
	}

	public void setClassid(long classid) {
		this.classid = classid;
	}

	public String getClassroom() {
		return this.classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getSchedule() {
		return this.schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public Harrisoncourse getHarrisoncourse() {
		return this.harrisoncourse;
	}

	public void setHarrisoncourse(Harrisoncourse harrisoncourse) {
		this.harrisoncourse = harrisoncourse;
	}

	public Harrisoninstructor getHarrisoninstructor() {
		return this.harrisoninstructor;
	}

	public void setHarrisoninstructor(Harrisoninstructor harrisoninstructor) {
		this.harrisoninstructor = harrisoninstructor;
	}

	public List<Harrisonenrollment> getHarrisonenrollments() {
		return this.harrisonenrollments;
	}

	public void setHarrisonenrollments(List<Harrisonenrollment> harrisonenrollments) {
		this.harrisonenrollments = harrisonenrollments;
	}

	public Harrisonenrollment addHarrisonenrollment(Harrisonenrollment harrisonenrollment) {
		getHarrisonenrollments().add(harrisonenrollment);
		harrisonenrollment.setHarrisonclass(this);

		return harrisonenrollment;
	}

	public Harrisonenrollment removeHarrisonenrollment(Harrisonenrollment harrisonenrollment) {
		getHarrisonenrollments().remove(harrisonenrollment);
		harrisonenrollment.setHarrisonclass(null);

		return harrisonenrollment;
	}

}