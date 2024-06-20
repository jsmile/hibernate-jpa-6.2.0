package entity;

import java.time.LocalDate;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.LazyGroup;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;

	private String title;		
	
	@LazyGroup("foo")
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "posted_on")
	private LocalDate postedOn;
	
	private String author;
	
	@JdbcTypeCode(SqlTypes.LONGVARCHAR)
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "text_content")
	private String textContent;

	public Post() {}
	public Post(String title, LocalDate postedOn, String author, String textContent) {
		this.title = title;
		this.postedOn = postedOn;
		this.author = author;
		this.textContent = textContent;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(LocalDate postedOn) {
		this.postedOn = postedOn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTextContent() {
		return textContent;
	}
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}
	

}