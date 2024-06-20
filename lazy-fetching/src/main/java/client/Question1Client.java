package client;

import entity.Guide;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Set;

public class Question1Client {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Student student = em.find(Student.class, 1L);
		System.out.println( "### student : " + student );
	
		Guide guide = em.find(Guide.class, 1L);
		Set<Student> students = guide.getStudents();

//		System.out.println( "### students : *" + students );
		em.detach(guide);
		System.out.println(guide.getStudents().size());

		txn.commit();	
		em.close();         
	}
}



