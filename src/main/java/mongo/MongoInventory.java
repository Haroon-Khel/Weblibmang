package mongo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class MongoInventory {
	
	private String name;
	private String author;
	private String genre;
	private MongoOperations op;
	private ApplicationContext context;
	
	public MongoInventory (String name, String author, String genre) {
		
		this.name = name;
		this.author = author;
		this.genre = genre;
		context = new AnnotationConfigApplicationContext(MongoConfig.class);
		op = (MongoOperations) context.getBean("mongoTemplate");
		
	}
	
	public void closeOp () {
		
		((AnnotationConfigApplicationContext) context).close();
		
	}
}

/* 
 * Fields: the usual + anything to be used as a lookup, or input data, so: name, author, genre, 
 * Methods: add, delete, edit, issue, return
 *
*/