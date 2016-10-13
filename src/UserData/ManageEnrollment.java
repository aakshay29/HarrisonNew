package UserData;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Harrisonclass;
import model.Harrisonenrollment;
import model.Harrisonstudent;


public class ManageEnrollment {

	public static Harrisonenrollment getUser(long userID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Harrisonenrollment user = em.find(Harrisonenrollment.class, userID);
		return user;
	}

	public static void insert(Harrisonenrollment user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(user);
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

	public static void update(Harrisonenrollment user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Harrisonenrollment user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(user));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static List<Harrisonenrollment> enrollmentByStudent(Harrisonstudent harrisonstudent) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Harrisonenrollment u " + "where u.harrisonstudent = :harrisonstudent";
		TypedQuery<Harrisonenrollment> q = em.createQuery(qString, Harrisonenrollment.class);
		q.setParameter("harrisonstudent", harrisonstudent);
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


}
