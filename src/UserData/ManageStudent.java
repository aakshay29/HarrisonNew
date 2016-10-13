package UserData;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Harrisoninstructor;
import model.Harrisonstudent;
import model.Harrisonuser;

public class ManageStudent {

	public static Harrisonstudent getUser(long studentid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Harrisonstudent student = em.find(Harrisonstudent.class, studentid);
		return student;
	}

	public static Harrisonstudent getStudent(Harrisonuser harrisonuser) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Harrisonstudent u where harrisonuser = :harrisonuser ";
		TypedQuery<Harrisonstudent> q = em.createQuery(qString, Harrisonstudent.class);
		q.setParameter("harrisonuser", harrisonuser);
		Harrisonstudent student = null;
		try {
			student = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return student;

	}

	public static void addStudent(Harrisonstudent student) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(student);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Harrisonstudent user) {
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

	public static void delete(Harrisonstudent user) {
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

	public static List<Harrisonstudent> studentByMajor(String major) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Harrisonstudent u " + "where u.major = :major";
		TypedQuery<Harrisonstudent> q = em.createQuery(qString, Harrisonstudent.class);
		q.setParameter("major", major);
		List<Harrisonstudent> students = null;
		try {
			students = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return students;

	}

	public static List<Harrisonstudent> students() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Harrisonstudent u ";
		TypedQuery<Harrisonstudent> q = em.createQuery(qString, Harrisonstudent.class);
		List<Harrisonstudent> students = null;
		try {
			students = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return students;

	}
}
