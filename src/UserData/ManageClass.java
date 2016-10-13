package UserData;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Harrisonclass;
import model.Harrisoncourse;
import model.Harrisoninstructor;

public class ManageClass {

	public static Harrisonclass getClass(long classid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Harrisonclass harrisonclass = em.find(Harrisonclass.class, classid);
		return harrisonclass;
	}

	public static void insert(Harrisonclass harrisonclass) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(harrisonclass);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void addClass(Harrisoncourse harrisoncourse, Harrisoninstructor harrisoninstructor, String classroom,
			String schedule, BigDecimal status, String semester) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			Harrisonclass harrisonclass = new Harrisonclass(harrisoncourse, harrisoninstructor, classroom, schedule,
					status, semester);
			em.persist(harrisonclass);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Harrisonclass harrisonclass) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(harrisonclass);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Harrisonclass harrisonclass) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(harrisonclass));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static List<Harrisonclass> classes() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Harrisonclass u ";
		TypedQuery<Harrisonclass> q = em.createQuery(qString, Harrisonclass.class);
		// q.setParameter("email", email);
		List<Harrisonclass> classes = null;
		try {
			classes = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return classes;

	}

	public static List<Harrisonclass> classes(String semester) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Harrisonclass u where  semester = :semester";
		TypedQuery<Harrisonclass> q = em.createQuery(qString, Harrisonclass.class);
		q.setParameter("semester", semester);
		List<Harrisonclass> classes = null;
		try {
			classes = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return classes;

	}

	public static List<Harrisonclass> classes(Harrisoninstructor harrisoninstructor) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Harrisonclass u where  harrisoninstructor = :harrisoninstructor";
		TypedQuery<Harrisonclass> q = em.createQuery(qString, Harrisonclass.class);
		q.setParameter("harrisoninstructor", harrisoninstructor);
		List<Harrisonclass> classes = null;
		try {
			classes = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return classes;

	}

	public static List<Harrisonclass> classes(Harrisoninstructor harrisoninstructor, String semester) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Harrisonclass u where  harrisoninstructor = :harrisoninstructor and semester = :semester";
		TypedQuery<Harrisonclass> q = em.createQuery(qString, Harrisonclass.class);
		q.setParameter("harrisoninstructor", harrisoninstructor);
		q.setParameter("semester", semester);
		List<Harrisonclass> classes = null;
		try {
			classes = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return classes;

	}

	public static List<Harrisonclass> classes(String semester, BigDecimal status) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Harrisonclass u where  harrisoninstructor = :harrisoninstructor and semester = :semester";
		TypedQuery<Harrisonclass> q = em.createQuery(qString, Harrisonclass.class);
		q.setParameter("semester", semester);
		q.setParameter("status", status);
		List<Harrisonclass> classes = null;
		try {
			classes = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return classes;

	}
}
