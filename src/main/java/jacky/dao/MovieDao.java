package jacky.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import jacky.model.Movie;
import jacky.util.JpaUtil;

public class MovieDao {
	final static Logger logger = Logger.getLogger(JpaUtil.class);
	public void create (Movie movie) {
		EntityManager em = JpaUtil.getSession();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(movie);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			logger.error("create error: " + e);
		} finally {
			if ((em != null) && (em.isOpen())) {
				em.close();
			}
		}
	}
	
	public void read (int id) {
		EntityManager em = JpaUtil.getSession();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.find(Movie.class, id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			logger.error("read error: " + e);
		} finally {
			if ((em != null) && (em.isOpen())) {
				em.close();
			}
		}
	}
	
	public void update (Movie movie) {
		EntityManager em = JpaUtil.getSession();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(movie);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			logger.error("update error: " + e);
		} finally {
			if ((em != null) && (em.isOpen())) {
				em.close();
			}
		}
	}
	
	public void delete (Movie movie) {
		EntityManager em = JpaUtil.getSession();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(movie);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			logger.error("delete error: " + e);
		} finally {
			if ((em != null) && (em.isOpen())) {
				em.close();
			}
		}
	}
}
