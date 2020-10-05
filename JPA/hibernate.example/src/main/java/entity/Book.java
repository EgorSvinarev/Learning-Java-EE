package entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.*;

@Entity
@Table(name = "book")
public class Book {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull @Size(min = 30, max = 2000)
	private String title;
	@NotNull @Positive
	private int price;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
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
