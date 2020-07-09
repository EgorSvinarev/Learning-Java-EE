package Main;

import BookService.BookService;
import IdGenerator.IdGenerator;
import IdGenerator.NumberIdGenerator;
import BookStorage.BookStorage;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		
		BookService bookService = container.instance().select(BookService.class).get();
		
		bookService.registerBook("Egor", "Pizdec");
		
		weld.shutdown();
	}

}
