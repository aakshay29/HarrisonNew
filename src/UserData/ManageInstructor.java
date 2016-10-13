package UserData;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Harrisoninstructor;
import model.Harrisonuser;

public class ManageInstructor {

	public static Harrisoninstructor getInstructor(long studentid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Harrisoninstructor student = em.find(Harrisoninstructor.class, studentid);
		return student;
	}
	
	public static Harrisoninstructor getInstructor(Harrisonuser harrisonuser) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Harrisoninstructor u where harrisonuser = :harrisonuser ";
		TypedQuery<Harrisoninstructor> q = em.createQuery(qString, Harrisoninstructor.class);
		q.setParameter("harrisonuser", harrisonuser);
		Harrisoninstructor instructor = null;
		try {
			instructor = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return instructor;

	}

	public static void addStudent(Harrisoninstructor student) {
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

	public static void update(Harrisoninstructor user) {
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

	public static void delete(Harrisoninstructor user) {
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

	public static List<Harrisoninstructor> instructorsByDepartment(String department) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Harrisoninstructor u where department = :department ";
		TypedQuery<Harrisoninstructor> q = em.createQuery(qString, Harrisoninstructor.class);
		q.setParameter("department", department);
		List<Harrisoninstructor> instructors = null;
		try {
			instructors = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return instructors;

	}
	
	public static List<Harrisoninstructor> instructors() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Harrisoninstructor u";
		TypedQuery<Harrisoninstructor> q = em.createQuery(qString, Harrisoninstructor.class);
		List<Harrisoninstructor> instructors = null;
		try {
			instructors = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return instructors;

	}
}
