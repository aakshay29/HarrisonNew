package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the HARRISONENROLLMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Harrisonenrollment.findAll", query="SELECT h FROM Harrisonenrollment h")
public class Harrisonenrollment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long enrollmentid;

	private String grade;

	private BigDecimal status;

	//bi-directional many-to-one association to Harrisonclass
	@ManyToOne
	@JoinColumn(name="CLASSID")
	private Harrisonclass harrisonclass;

	//bi-directional many-to-one association to Harrisonstudent
	@ManyToOne
	@JoinColumn(name="STUDENTID")
	private Harrisonstudent harrisonstudent;

	public Harrisonenrollment(Harrisonstudent harrisonstudent,Harrisonclass harrisonclass, BigDecimal status, String grade) {
		this.harrisonstudent = harrisonstudent;
		this.harrisonclass = harrisonclass;
		this.status = status;
		this.grade = grade;
	}
	
	public Harrisonenrollment() {
	}
	
	public long getEnrollmentid() {
		return this.enrollmentid;
	}

	public void setEnrollmentid(long enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public Harrisonclass getHarrisonclass() {
		return this.harrisonclass;
	}

	public void setHarrisonclass(Harrisonclass harrisonclass) {
		this.harrisonclass = harrisonclass;
	}

	public Harrisonstudent getHarrisonstudent() {
		return this.harrisonstudent;
	}

	public void setHarrisonstudent(Harrisonstudent harrisonstudent) {
		this.harrisonstudent = harrisonstudent;
	}

}