package org.formation.hibernate.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.formation.hibernate.entity.Actor;
import org.formation.hibernate.entity.Movie;
import org.formation.hibernate.entity.Person2;

public class TestClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

//			Person2 p = new Person2();
//			p.setName("Bob");
//			
//			em.persist(p);

			
//			Person2 p = em.find(Person2.class, 1L);
//			System.out.println(p);
			
//			p.setAge(145);
			
//			Movie m = em.find(Movie.class, 9L);
//			System.out.println("Movie : "+m);
			
//			Actor a = em.find(Actor.class, 7L);
//			System.out.println("Actor : "+a);
			
			TypedQuery<Movie> tq = em.createQuery("SELECT m FROM Movie m JOIN FETH m.actors WHERE m.id = :id",Movie.class);
			tq.setParameter("id",9L);
			Movie m = tq.getSingleResult();
			System.out.println("Movie : "+m.getActors());
			
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
