
package org.formation.hibernate.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.formation.hibernate.entity.Actor;
import org.formation.hibernate.entity.Customer;
import org.formation.hibernate.entity.Movie;

public class TestClientPersist {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			
//			Customer c = new Customer();
//			c.setName("Joe Biden");
//			em.persist(c);
			
			Movie m1 = new Movie("Movie1");
			Movie m2 = new Movie("Movie2");
			
			Actor a1 = new Actor("Actor1");
			Actor a2 = new Actor("Actor2");
			

			//-------- cas 1 qui persist 
//			em.persist(a1);
//			em.persist(a2);
//			
//			m1.getActors().add(a1);
//			m2.getActors().add(a2);
//			
//			em.persist(m1);
//			em.persist(m2);
			
			//------------- cas 2 qui ne persiste pas la table d'association 
			em.persist(m1);
			em.persist(m2);
			
//			a1.getMovies().add(m1);
//			a2.getMovies().add(m2);
			
			a1.addMovie(m1);
			a2.addMovie(m2);
			
			em.persist(a1);
			em.persist(a2);
			

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}
}
