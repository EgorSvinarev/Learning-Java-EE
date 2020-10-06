package entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.validation.constraints.*;

@Entity
@Table(name = "book")
@NamedQuery(name = "getBooksByGreaterPrice", query = "SELECT b FROM Book b WHERE b.price > ?1")
@NamedQuery(name= "getBooksByLessPrice", query = "SELECT b FROM Book b WHERE b.price < ?1")
public class Book {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull @Size(min = 30, max = 100)
	private String title;
	@NotNull @Positive
	private int price;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
