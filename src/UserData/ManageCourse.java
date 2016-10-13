package UserData;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Harrisoncourse;

public class ManageCourse {

	public static Harrisoncourse getCourse(long courseid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Harrisoncourse course = em.find(Harrisoncourse.class, courseid);
		return course;
	}

	public static void insert(Harrisoncourse course) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(course);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void addCourse(BigDecimal subjectcode, String coursename, String coursedescription,
			BigDecimal numberofcredits, BigDecimal available) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			Harrisoncourse course = new Harrisoncourse(subjectcode, coursename, coursedescription, numberofcredits,
					available);
			em.persist(course);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Harrisoncourse course) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(course);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Harrisoncourse course) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(course));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static List<Harrisoncourse> courses() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select b from Harrisoncourse b";
		TypedQuery<Harrisoncourse> q = em.createQuery(qString, Harrisoncourse.class);
		List<Harrisoncourse> courses = null;

		try {
			courses = q.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return courses;

	}

	public static List<Harrisoncourse> availableCourses() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select b from Harrisoncourse b where available = 1 ";
		TypedQuery<Harrisoncourse> q = em.createQuery(qString, Harrisoncourse.class);
		List<Harrisoncourse> courses = null;

		try {
			courses = q.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return courses;

	}

}
