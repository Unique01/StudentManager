package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Login {
	@Id	
	@GeneratedValue
	@Column
	private int id;
	
	@Column
	private String email;
	
	@Column
	private String safePassword;
	
	@Column
	private String salt;
	
	@OneToOne(mappedBy="login",cascade=CascadeType.PERSIST)
	private User user;
	
	public Login(String email, String safePassword, String salt) {
		this.email = email;
		this.safePassword = safePassword;
		this.salt=salt;	
	}
	
	public Login() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSafePassword() {
		return safePassword;
	}

	public void setSafePassword(String safePassword) {
		this.safePassword = safePassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {

		this.salt = salt;
	}
	
	public User getUser() {

		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
		
}
