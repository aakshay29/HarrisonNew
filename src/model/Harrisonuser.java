package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HARRISONUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Harrisonuser.findAll", query="SELECT h FROM Harrisonuser h")
public class Harrisonuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userid;

	private String email;

	private String name;

	private String password;

	@Column(name="\"ROLE\"")
	private BigDecimal role;

	//bi-directional many-to-one association to Harrisoninstructor
	@OneToMany(mappedBy="harrisonuser")
	private List<Harrisoninstructor> harrisoninstructors;

	//bi-directional many-to-one association to Harrisonstudent
	@OneToMany(mappedBy="harrisonuser")
	private List<Harrisonstudent> harrisonstudents;

	public Harrisonuser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getRole() {
		return this.role;
	}

	public void setRole(BigDecimal role) {
		this.role = role;
	}

	public List<Harrisoninstructor> getHarrisoninstructors() {
		return this.harrisoninstructors;
	}

	public void setHarrisoninstructors(List<Harrisoninstructor> harrisoninstructors) {
		this.harrisoninstructors = harrisoninstructors;
	}

	public Harrisoninstructor addHarrisoninstructor(Harrisoninstructor harrisoninstructor) {
		getHarrisoninstructors().add(harrisoninstructor);
		harrisoninstructor.setHarrisonuser(this);

		return harrisoninstructor;
	}

	public Harrisoninstructor removeHarrisoninstructor(Harrisoninstructor harrisoninstructor) {
		getHarrisoninstructors().remove(harrisoninstructor);
		harrisoninstructor.setHarrisonuser(null);

		return harrisoninstructor;
	}

	public List<Harrisonstudent> getHarrisonstudents() {
		return this.harrisonstudents;
	}

	public void setHarrisonstudents(List<Harrisonstudent> harrisonstudents) {
		this.harrisonstudents = harrisonstudents;
	}

	public Harrisonstudent addHarrisonstudent(Harrisonstudent harrisonstudent) {
		getHarrisonstudents().add(harrisonstudent);
		harrisonstudent.setHarrisonuser(this);

		return harrisonstudent;
	}

	public Harrisonstudent removeHarrisonstudent(Harrisonstudent harrisonstudent) {
		getHarrisonstudents().remove(harrisonstudent);
		harrisonstudent.setHarrisonuser(null);

		return harrisonstudent;
	}

}