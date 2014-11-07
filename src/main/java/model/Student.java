package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id	
	@GeneratedValue
	@Column
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String surname;
	
	@ManyToOne
	private Classe classe;
	
	@Column
	private float mean;
	
	@ManyToMany
	private List<Event> events;
	
	@Column
	private Date birthDate;

	public Student(String name, String surname, Classe classe, float mean, List<Event> events, Date birthDate) {
		this.name = name;
		this.surname = surname;
		this.classe = classe;
		this.mean = mean;
		this.events = events;
		this.birthDate = birthDate;
	}
	
	public Student(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public float getMean() {
		return mean;
	}

	public void setMean(float mean) {
		this.mean = mean;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> eventList) {
		this.events = eventList;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return surname + " " + name + " " + birthDate;
	}
	
	/*Nous partons du principe que toutes les notes ont le meme coefficient. 
	 * Une fonctionalité supplémentaire pourrait nous permettre d'affecter des coefficients personalisés*/
	
	public void calculateMean(){
		float m = 0;
		float i = 0;
		
		for (Event event : events){
			m = m +event.getMark();
			i++;
		}
		
		m = m/i;
	}
	
	
	
	
	
}
