package entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Movie {
	
	//1. Before Hibernate 5.x, GenerationType.AUTO used GenerationType.IDENTITY as default strategy
	//2. After Hibernate 5.x, GenerationType.AUTO used GenerationType.SEQUENCE as default strategy
	//3. To follow the course with Hibernate 6.y, use GenerationType.IDENTITY strategy explicitly
	//4. Q&A on AUTO vs IDENTITY: https://www.udemy.com/course/hibernate-and-jpa-fundamentals/learn/lecture/26324154#questions/937412
	//5. In the lecture on "Pre-INSERT Identifier Generation", we talk more about AUTO, IDENTITY, SEQUENCE and TABLE strategies
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="ID")	
	private Long id;
	
	private String name;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinTable(
		name="movie_actor",
		joinColumns={@JoinColumn(name="movie_id")},
		inverseJoinColumns={@JoinColumn(name="actor_id")}
	)
	private Set<Actor> actors = new HashSet<Actor>();	
	
	public Movie() {}
	public Movie(String name) {
		this.name = name;
	}
	
	public Set<Actor> getActors() {
		return actors;
	}
	
}




