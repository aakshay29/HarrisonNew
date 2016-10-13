package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HARRISONINSTRUCTOR database table.
 * 
 */
@Entity
@NamedQuery(name="Harrisoninstructor.findAll", query="SELECT h FROM Harrisoninstructor h")
public class Harrisoninstructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long instructorid;

	private String department;

	private BigDecimal officenumber;

	//bi-directional many-to-one association to Harrisonclass
	@OneToMany(mappedBy="harrisoninstructor")
	private List<Harrisonclass> harrisonclasses;

	//bi-directional many-to-one association to Harrisonuser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Harrisonuser harrisonuser;

	public Harrisoninstructor() {
	}

	public long getInstructorid() {
		return this.instructorid;
	}

	public void setInstructorid(long instructorid) {
		this.instructorid = instructorid;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public BigDecimal getOfficenumber() {
		return this.officenumber;
	}

	public void setOfficenumber(BigDecimal officenumber) {
		this.officenumber = officenumber;
	}

	public List<Harrisonclass> getHarrisonclasses() {
		return this.harrisonclasses;
	}

	public void setHarrisonclasses(List<Harrisonclass> harrisonclasses) {
		this.harrisonclasses = harrisonclasses;
	}

	public Harrisonclass addHarrisonclass(Harrisonclass harrisonclass) {
		getHarrisonclasses().add(harrisonclass);
		harrisonclass.setHarrisoninstructor(this);

		return harrisonclass;
	}

	public Harrisonclass removeHarrisonclass(Harrisonclass harrisonclass) {
		getHarrisonclasses().remove(harrisonclass);
		harrisonclass.setHarrisoninstructor(null);

		return harrisonclass;
	}

	public Harrisonuser getHarrisonuser() {
		return this.harrisonuser;
	}

	public void setHarrisonuser(Harrisonuser harrisonuser) {
		this.harrisonuser = harrisonuser;
	}

}