package mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventory")
public class BookBean {
	
	@Id
	private String id;
	private String name;
	private String author;
	private String genre;
	private int count;
	
	public BookBean (String name, String author, String genre, int count) {
		
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.count = count;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return String.format("{\"_id\": \"%s\", \"name\": \"%s\", \"author\": \"%s\", \"genre\": \"%s\", \"count\": %s}", 
				id, getName(), getAuthor(), getGenre(), getCount());
	}

}
