package UserData;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Harrisonclass;
import model.Harrisonenrollment;
import model.Harrisoninstructor;
import model.Harrisonstudent;


public class ManageEnrollment {

	public static Harrisonenrollment getUser(long enrollmentid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Harrisonenrollment enrollment = em.find(Harrisonenrollment.class, enrollmentid);
		return enrollment;
	}

	public static void insert(Harrisonenrollment enrollment) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(enrollment);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void enroll(Harrisonstudent harrisonstudent,Harrisonclass harrisonclass, BigDecimal status, String grade) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			Harrisonenrollment user= new Harrisonenrollment( harrisonstudent, harrisonclass,  status,  grade);
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Harrisonenrollment enrollment) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(enrollment);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Harrisonenrollment enrollment) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(enrollment));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
//
//	public static List<Harrisonenrollment> enrollmentByStudent(Harrisonstudent harrisonstudent) {
//		EntityManager em = DBUtil.getEmFactory().createEntityManager();
//		String qString = "Select u from Harrisonenrollment u " + "where u.harrisonstudent = :harrisonstudent";
//		TypedQuery<Harrisonenrollment> q = em.createQuery(qString, Harrisonenrollment.class);
//		q.setParameter("harrisonstudent", harrisonstudent);
//		List<Harrisonenrollment> enrollments = null;
//		try {
//			enrollments = q.getResultList();
//		} catch (NoResultException e) {
//			System.out.println(e);
//		} finally {
//			em.close();
//		}
//		return enrollments;
//
//	}

	
	public static List<Harrisonenrollment> enrollmentByInstructor(Harrisoninstructor harrisoninstructor, String semester) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select e from Harrisonenrollment e where e.harrisonclass in (select c from Harrisonclass c where c.harrisoninstructor = :harrisoninstructor and c.semester = :semester)";
		TypedQuery<Harrisonenrollment> q = em.createQuery(qString, Harrisonenrollment.class);
		q.setParameter("harrisoninstructor", harrisoninstructor);
		q.setParameter("semester", semester);
		List<Harrisonenrollment> enrollments = null;
		try {
			enrollments = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return enrollments;

	}
	
	public static Harrisonenrollment enrollmentByStudentClass(Harrisonstudent harrisonstudent, Harrisonclass harrisonclass) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select e from Harrisonenrollment e where e.harrisonclass = :harrisonclass and e.harrisonstudent = :harrisonstudent";
		TypedQuery<Harrisonenrollment> q = em.createQuery(qString, Harrisonenrollment.class);
		q.setParameter("harrisonstudent", harrisonstudent);
		q.setParameter("harrisonclass", harrisonclass);
		Harrisonenrollment enrollment = null;
		try {
			enrollment = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return enrollment;

	}
	
	public static List<Harrisonenrollment> EnrollmentsBYInstuctorSemester(Harrisoninstructor harrisoninstructor, String semester) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select e from Harrisonenrollment e where e.harrisonclass in (select c from Harrisonclass c where c.harrisoninstructor = :harrisoninstructor and c.semester = :semester)";
		TypedQuery<Harrisonenrollment> q = em.createQuery(qString, Harrisonenrollment.class);
		q.setParameter("harrisoninstructor", harrisoninstructor);
		q.setParameter("semester", semester);
		List<Harrisonenrollment> enrolments = null;
		try {
			enrolments = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return enrolments;

	}
}
