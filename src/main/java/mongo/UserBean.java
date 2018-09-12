package mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
public class UserBean {
	
	@Id
	private String id;
	private String username;
	private String password;
	private String account;
	
	public UserBean (String username, String password, String account) {
		this.username = username;
		this.password = password;
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return String.format("{\"_id\": \"%s\", \"username\": \"%s\", \"password\": \"%s\", \"account\": \"%s\"}",
				id, getUsername(), getPassword(), getAccount());
	}
	
	

}
