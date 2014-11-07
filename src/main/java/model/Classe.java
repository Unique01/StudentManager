package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Classe {
	@Id	
	@GeneratedValue
	@Column
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String year;
	
	@Column
	private String adress;
	
	@OneToMany(mappedBy="classe",cascade=CascadeType.PERSIST)
	private List<Student> students;
	
	public Classe(String name, String year, String adress, List<Student> students){
		this.name =name;
		this.year=year;
		this.adress=adress;
		this.students=students;
	}
	
	public Classe(){
		
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return name + ", " + adress + " (" + year + ")";
	}
	
}
