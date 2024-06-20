package client;

import java.time.LocalDate;
import java.time.Month;

import entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BytecodeEnhancementClient {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Post post = new Post();
		post.setTitle("Bytecode Enhancement");
		post.setPostedOn(LocalDate.of(2023, Month.APRIL, 1));
		post.setAuthor("The Author");
		post.setTextContent("A good long post on bytecode enhancement ...");
		
		em.persist(post);
		
		em.getTransaction().commit();
		em.close();       
		
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();

		Post returnedPost = em2.find(Post.class, 1L);
		returnedPost.getPostedOn();
		
		em2.getTransaction().commit();
		em2.close();    
	}
}