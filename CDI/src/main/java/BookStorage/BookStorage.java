package BookStorage;

import java.util.Map;
import java.util.HashMap;
import Book.Book;

public class BookStorage {

	private Map<String, Book> storage;
	
	public BookStorage() {
		this.storage = new HashMap<String, Book>();
	}
	
	synchronized public void putBook(Book book) {
		String bookId = book.getId();
		
		this.storage.put(bookId, book);
	}
		
}
