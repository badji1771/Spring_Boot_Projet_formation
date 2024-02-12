
package org.formation.hibernate.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.formation.hibernate.entity.Customer;
import org.formation.hibernate.entity.Movie;

public class TestClientFind {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		TypedQuery<Movie> tq = em.createQuery("SELECT m FROM Movie m JOIN FETCH m.actors WHERE m.id = :id",Movie.class);
		tq.setParameter("id",9L);
		Movie m = tq.getSingleResult();
		m.getActors().size();
		
		
		em.close();
		emf.close();
		System.out.println("Movie : "+m);
//		try {
//			txn.begin();
//			
//			
//			
//			Customer c = em.find(Customer.class, 1L);
//			System.out.println(c);
//		
//			c.setName("Superman");
//
//			
//			
//			
//			
//			
//			
//			txn.commit();
//		} catch (Exception e) {
//			if (txn != null) {
//				txn.rollback();
//			}
//			e.printStackTrace();
//		} finally {
//			if (em != null) {
//				em.close();
//			}
//			if (emf != null) {
//				emf.close();
//			}
//		}
	}
}
