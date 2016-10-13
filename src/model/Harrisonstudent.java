package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HARRISONSTUDENT database table.
 * 
 */
@Entity
@NamedQuery(name="Harrisonstudent.findAll", query="SELECT h FROM Harrisonstudent h")
public class Harrisonstudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long studentid;

	private String major;

	private BigDecimal yearofentry;

	//bi-directional many-to-one association to Harrisonenrollment
	@OneToMany(mappedBy="harrisonstudent")
	private List<Harrisonenrollment> harrisonenrollments;

	//bi-directional many-to-one association to Harrisonuser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Harrisonuser harrisonuser;

	public Harrisonstudent() {
	}

	public long getStudentid() {
		return this.studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public BigDecimal getYearofentry() {
		return this.yearofentry;
	}

	public void setYearofentry(BigDecimal yearofentry) {
		this.yearofentry = yearofentry;
	}

	public List<Harrisonenrollment> getHarrisonenrollments() {
		return this.harrisonenrollments;
	}

	public void setHarrisonenrollments(List<Harrisonenrollment> harrisonenrollments) {
		this.harrisonenrollments = harrisonenrollments;
	}

	public Harrisonenrollment addHarrisonenrollment(Harrisonenrollment harrisonenrollment) {
		getHarrisonenrollments().add(harrisonenrollment);
		harrisonenrollment.setHarrisonstudent(this);

		return harrisonenrollment;
	}

	public Harrisonenrollment removeHarrisonenrollment(Harrisonenrollment harrisonenrollment) {
		getHarrisonenrollments().remove(harrisonenrollment);
		harrisonenrollment.setHarrisonstudent(null);

		return harrisonenrollment;
	}

	public Harrisonuser getHarrisonuser() {
		return this.harrisonuser;
	}

	public void setHarrisonuser(Harrisonuser harrisonuser) {
		this.harrisonuser = harrisonuser;
	}

}