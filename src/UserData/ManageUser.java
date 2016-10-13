package UserData;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Harrisonuser;

public class ManageUser {

	public static Harrisonuser getUser(long userID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Harrisonuser user = em.find(Harrisonuser.class, userID);
		return user;
	}

	public static void insert(Harrisonuser user) {
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
	
	public static void addUser( String email, String name, String password, BigDecimal role) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			Harrisonuser user= new Harrisonuser(email,  name,  password,  role);
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Harrisonuser user) {
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

	public static void delete(Harrisonuser user) {
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

	public static Harrisonuser getUserByEmail(String email) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Harrisonuser u " + "where u.email = :email";
		TypedQuery<Harrisonuser> q = em.createQuery(qString, Harrisonuser.class);
		q.setParameter("email", email);
		Harrisonuser user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;

	}

	public static Harrisonuser isValidUser(String email, String password) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select b from Harrisonuser b " + "where b.useremail = :email and b.password = :pass";
		TypedQuery<Harrisonuser> q = em.createQuery(qString, Harrisonuser.class);
		Harrisonuser user = null;
		q.setParameter("email", email);
		q.setParameter("pass", password);

		try {
			user = q.getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;

	}

}
