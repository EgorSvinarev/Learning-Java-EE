package BookService;

import IdGenerator.IdGenerator;
import Book.Book;
import BookStorage.BookStorage;
import IdGenerator.Qualifiers.*;
import javax.inject.Inject;

public class BookService {

	@Inject @NumberIdentificator
	private IdGenerator idGenerator;
	@Inject
	private BookStorage bookStorage;
		
	public void registerBook(String name, String desc) {
		Book book = new Book();
		book.setId(this.idGenerator.getId());
		book.setName(name);
		book.setDescription(desc);
		
		System.out.println(book.getId());
		
		this.bookStorage.putBook(book);
	}
	
}
