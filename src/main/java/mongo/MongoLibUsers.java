package mongo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class MongoLibUsers {
	
	private String firstname;
	private String lastname;
	private String dob;
	private String contact;
	private MongoOperations op;
	private ApplicationContext context;
	
	
	public MongoLibUsers(String firstname, String lastname, String dob, String contact) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.contact = contact;
		context = new AnnotationConfigApplicationContext(MongoConfig.class);
		op = (MongoOperations) context.getBean("mongoTemplate");
		
	}
	

	public boolean checkUser() {
		
		boolean isThere;
		Criteria crit = new Criteria();
		crit.and("firstname").is(getFirstname());
		crit.and("lastname").is(getLastname());
		crit.and("dob").is(getDob());
		Query query = new Query(crit);
		
		LibUserBean libUser = op.findOne(query, LibUserBean.class);
		if (libUser != null) {
			isThere = true;
		}
		else {
			isThere = false;
		}
		
		return isThere;
		
	}
	
	//In the servlet, once the Checkuser method returns true, this method can then be called
	public void addLibUser() {
		
		LibUserBean libUser = new LibUserBean(getFirstname(), getLastname(), getDob(), getContact(), "0");
		op.save(libUser);
		
	}
	
	public void editUser() {
		//tbc
	}
	
	public void getAllUser() {
		//tbc
	}
	
	public void closeOp() {
		
		((AnnotationConfigApplicationContext) context).close();
		
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

}
