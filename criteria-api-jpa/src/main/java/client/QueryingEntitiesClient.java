
package client;

import java.util.List;

import entity.Guide;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class QueryingEntitiesClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();			
			
			//QUERYING ENTITIES						
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Guide> criteria = builder.createQuery( Guide.class );
			Root<Guide> root = criteria.from( Guide.class );
			criteria.select(root);
			
			TypedQuery<Guide> query = em.createQuery(criteria);
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}   
			
			
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
		}

	}
}














