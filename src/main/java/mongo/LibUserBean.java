package mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "libusers")
public class LibUserBean {
	
	@Id
	private String id;
	private String firstname;
	private String lastname;
	private String dob;
	private String contact;
	private String books;
	
	public LibUserBean(String firstname, String lastname, String dob, String contact, String books) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.contact = contact;
		this.books = books;
		
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getDob() {
		return dob;
	}

	public String getContact() {
		return contact;
	}

	public String getBooks() {
		return books;
	}

	public void setBooks(String books) {
		this.books = books;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@Override
	public String toString() {
		return String.format("{\"_id\": \"%s\", \"firstname\": \"%s\", \"lastname\": \"%s\", \"dob\": \"%s\", \"contact\": \"%s\", \"books\": \"%s\"}", 
				id, getFirstname(), getLastname(), getContact(), getDob(), getBooks());
	}

}
