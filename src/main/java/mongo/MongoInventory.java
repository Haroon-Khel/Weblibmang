package mongo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class MongoInventory {
	
	private String name;
	private String author;
	private String genre;
	private MongoOperations op;
	private ApplicationContext context;
	private List<BookBean> allBooks;
	private ArrayList<String> allBooksToString;
	
	//Constructor for queries involving only one book
	public MongoInventory (String name, String author, String genre) {
		
		this.name = name;
		this.author = author;
		this.genre = genre;
		context = new AnnotationConfigApplicationContext(MongoConfig.class);
		op = (MongoOperations) context.getBean("mongoTemplate");
		
	}
	//Constructor for GET methods
	public MongoInventory () {
		
		context = new AnnotationConfigApplicationContext(MongoConfig.class);
		op = (MongoOperations) context.getBean("mongoTemplate");		
		
	}
	
	//To check if book is present. For methods that include add, removing, etc
	private boolean checkBook() {
		
		boolean isThere;
		
		Criteria crit = new Criteria();
		crit.and("name").is(getName());
		crit.and("author").is(getAuthor());
		crit.and("genre").is(getGenre());
		Query query = new Query(crit);
		
		BookBean book = op.findOne(query, BookBean.class);
		
		if (book != null) {
			isThere = true;
		} 
		else {
			isThere = false;
		}
		return isThere;

	}
	
	//The book needs to be created in the servlet, then passed into this method
	public void addBook() {
		
		if (checkBook()) {
			System.out.println("The Book is aleady there, I shall instead add to its count");
			//Update 
		}
		else {

			BookBean book = new BookBean(getName(), getAuthor(), getGenre(), 1);
			op.save(book);
		}
		
	}
	
	public void updateBook() {
		//tbc
	}
	
	public ArrayList<String> getAllBooks() {
		
		allBooks = op.findAll(BookBean.class);
		allBooksToString = new ArrayList<String>();
		for (BookBean book : allBooks) {
			
			allBooksToString.add(book.toString());
			
		}
		
		return allBooksToString;
		
	}
	
	public void closeOp () {
		
		((AnnotationConfigApplicationContext) context).close();
		
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}

/* 
 * Fields: the usual + anything to be used as a lookup, or input data, so: name, author, genre, 
 * Methods: add, delete, edit, issue, return, anything that interacts with Inventory
 *
*/