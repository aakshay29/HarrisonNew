package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the HARRISONCOURSE database table.
 * 
 */
@Entity
@NamedQuery(name = "Harrisoncourse.findAll", query = "SELECT h FROM Harrisoncourse h")
public class Harrisoncourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseid;

	private BigDecimal available;

	private String coursedescription;

	private String coursename;

	private BigDecimal numberofcredits;

	private BigDecimal subjectcode;

	// bi-directional many-to-one association to Harrisonclass
	@OneToMany(mappedBy = "harrisoncourse")
	private List<Harrisonclass> harrisonclasses;

	public Harrisoncourse() {
	}

	public Harrisoncourse(BigDecimal subjectcode, String coursename, String coursedescription,
			BigDecimal numberofcredits, BigDecimal available) {
		this.available = available;

		this.coursedescription = coursedescription;

		this.coursename = coursename;

		this.numberofcredits = numberofcredits;

		this.subjectcode = subjectcode;
	}

	public long getCourseid() {
		return this.courseid;
	}

	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}

	public BigDecimal getAvailable() {
		return this.available;
	}

	public void setAvailable(BigDecimal available) {
		this.available = available;
	}

	public String getCoursedescription() {
		return this.coursedescription;
	}

	public void setCoursedescription(String coursedescription) {
		this.coursedescription = coursedescription;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public BigDecimal getNumberofcredits() {
		return this.numberofcredits;
	}

	public void setNumberofcredits(BigDecimal numberofcredits) {
		this.numberofcredits = numberofcredits;
	}

	public BigDecimal getSubjectcode() {
		return this.subjectcode;
	}

	public void setSubjectcode(BigDecimal subjectcode) {
		this.subjectcode = subjectcode;
	}

	public List<Harrisonclass> getHarrisonclasses() {
		return this.harrisonclasses;
	}

	public void setHarrisonclasses(List<Harrisonclass> harrisonclasses) {
		this.harrisonclasses = harrisonclasses;
	}

	public Harrisonclass addHarrisonclass(Harrisonclass harrisonclass) {
		getHarrisonclasses().add(harrisonclass);
		harrisonclass.setHarrisoncourse(this);

		return harrisonclass;
	}

	public Harrisonclass removeHarrisonclass(Harrisonclass harrisonclass) {
		getHarrisonclasses().remove(harrisonclass);
		harrisonclass.setHarrisoncourse(null);

		return harrisonclass;
	}

}