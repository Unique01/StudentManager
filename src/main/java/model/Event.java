package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Event {
	@Id	
	@GeneratedValue
	@Column
	private int id;
	
	@Column
	private Date date;
	
	@Column
	private String description;
	
	@Column
	private Subject subject;
	
	@Column
	private float mark;
	
	@ManyToMany
	private List<Classe> classes;
	
	public Event(Date date, String description, Subject subject, float mark, List<Classe> classes){
		this.date = date;
		this.description = description;
		this.subject =subject;
		this.mark = mark;
		this.classes = classes;
	}
	
	public Event(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Enumerated
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return subject + " (" + description + ") : " + date;
	}
	
}
