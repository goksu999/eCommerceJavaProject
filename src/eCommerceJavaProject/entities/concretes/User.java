package eCommerceJavaProject.entities.concretes;

import eCommerceJavaProject.entities.abstracts.Entity;

public class User implements Entity{
	
	private int id;
	private String firsName;
	private String lastName;
	private String eMail;
	private String password;
	private boolean verified;
	
	public User(int id, String firsName, String lastName, String eMail, String password, boolean verified) {
		super();
		this.id = id;
		this.firsName = firsName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
		this.verified=verified;
	}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirsName() {
		return firsName;
	}


	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getemail() {
		return eMail;
	}


	public void setemail(String eMail) {
		this.eMail = eMail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	public boolean isVerified() {
		return verified;
	}



	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
}
