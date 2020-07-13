package BookService;

import IdGenerator.IdGenerator;
import Book.Book;
import BookStorage.BookStorage;
import Logger.Logger;
import IdGenerator.Qualifiers.*;
import javax.inject.Inject;
import javax.interceptor.*;

public class BookService {

	@Inject @NumberIdentificator
	private IdGenerator idGenerator;
	@Inject
	private BookStorage bookStorage;
	@Inject
	private Logger logger;
	
	public void registerBook(String name, String desc) {
		Book book = new Book();
		book.setId(this.idGenerator.getId());
		book.setName(name);
		book.setDescription(desc);
		
		System.out.println(book.getId());
		
		this.bookStorage.putBook(book);
	}
	
	@AroundInvoke
	private Object logging(InvocationContext ic) throws Exception{
		logger.log(ic.getTarget().toString() + " - " + ic.getMethod().getName());
		try {
			return ic.proceed();
		}
		finally { }
	}
	
}
