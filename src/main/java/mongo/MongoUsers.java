package mongo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class MongoUsers {
	
	private String username;
	private String password;
	private String account;
	private MongoOperations op;
	private ApplicationContext context;
	
	public MongoUsers(String username, String password, String account) {
		
		this.username = username;
		this.password = password;
		this.account = account;
		context = new AnnotationConfigApplicationContext(MongoConfig.class);
		op = (MongoOperations) context.getBean("mongoTemplate");		
		
	}
	
	//Querys User collection to check for a user
	public boolean checkUser() {
		
		boolean isThere;
		
		Criteria crit = new Criteria();
		crit.and("username").is(getUsername());
		crit.and("password").is(getPassword());
		crit.and("account").is(getAccount());
		Query query = new Query(crit);
	//	System.out.printf("%n%s %s %s%n", getUsername(), getPassword(), getAccount());
		
		UserBean user = op.findOne(query, UserBean.class);
		
		if (user!=null) {
			isThere = true;
		}
		else {
			isThere = false;
		}
		
		return isThere;
	}
	
	public void registerUser() {
		
	}
	
	public void closeOp() {
		
		((AnnotationConfigApplicationContext) context).close();
		
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAccount() {
		return account;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	

}
