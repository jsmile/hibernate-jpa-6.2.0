package entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Guide {

	//1. Before Hibernate 5.x, GenerationType.AUTO used GenerationType.IDENTITY as default strategy
	//2. After Hibernate 5.x, GenerationType.AUTO used GenerationType.SEQUENCE as default strategy
	//3. To follow the course with Hibernate 6.y, use GenerationType.IDENTITY strategy explicitly
	//4. Q&A on AUTO vs IDENTITY: https://www.udemy.com/course/hibernate-and-jpa-fundamentals/learn/lecture/26324154#questions/937412
	//5. In the lecture on "Pre-INSERT Identifier Generation", we talk more about AUTO, IDENTITY, SEQUENCE and TABLE strategies
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="ID")	
	private Long id;
	
	@Column(name = "staff_id", nullable = false)
	private String staffId;
	private String name;
	private Integer salary;
	
//	@OneToMany(mappedBy="guide")
//	@OneToMany(mappedBy="guide", cascade={CascadeType.PERSIST})
	@OneToMany(mappedBy="guide", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<Student> students = new HashSet<Student>();

	public Guide() {}
	public Guide(String staffId, String name, Integer salary) {
		this.staffId = staffId;
		this.name = name;
		this.salary = salary;
	}
	
	public Set<Student> getStudents() {
		return students;
	}
	public void addStudent(Student student) {
		students.add(student);
		student.setGuide(this);
	}

	public void removeStudent(Student student) {
		students.remove(student);
		student.setGuide(null);
	}

}