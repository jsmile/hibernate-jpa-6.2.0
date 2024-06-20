package entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	private Long id;
	
	@Column(name="enrollment_id", nullable=false)
	private String enrollmentId;	
	
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="guide_id")
	private Guide guide;
	
	public Student() {}
	public Student(String enrollmentId, String name) {
		this.enrollmentId = enrollmentId;
		this.name = name;
	}

	public Guide getGuide() {
		return guide;
	}	
	public void setGuide(Guide guide) {
		this.guide = guide;
	}
	public Long getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getEnrollmentId() {
		return enrollmentId;
	}	
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(enrollmentId).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) return false;
		Student other = (Student) obj;
		return new EqualsBuilder().append(enrollmentId, other.enrollmentId).isEquals();
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ",\t enrollmentId=" + enrollmentId + ",\t name=" + name + "]";
	}	
	
}


