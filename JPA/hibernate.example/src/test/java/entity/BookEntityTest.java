package entity;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import javax.persistence.*;
import java.util.List;
import javax.validation.ConstraintViolationException;

public class BookEntityTest {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookTest");
	private EntityManager em;
	private EntityTransaction tx;
	
	@Before
	public void initEntityManager() throws Exception {
		this.em = this.emf.createEntityManager();
		this.tx = this.em.getTransaction();
	}
	
	@After
	public void finalizeEntityManager() throws Exception {
		if (this.em != null) {
			this.em.close();
		}
	}
	
	@Test
	public void testFindingBookById() {

		// Should return "Hello, world!" for id = 1
		
		Book book = this.em.find(Book.class, 1);
		assertEquals(book.getTitle(), "Hello, world!");
	}

	@Test
	public void testFindingBooksByGreaterPrice() {
		//	Should return list of books with certain id.
		
		Query q = this.em.createNamedQuery("getBooksByGreaterPrice");
		q.setParameter(1, 10);
		
		List<Book> books = q.getResultList();
		
		// Returned book's id should be equal to 2	
		if (books.size() != 1 || books.get(0).getId() != 2) {
			fail("Returned book's id with a greater price = " + books.get(0).getId());
		}
	}
	
	@Test
	public void testFindingBooksByLessPrice() {
		//	Should return list of books with certain id.
		
		Query q = this.em.createNamedQuery("getBooksByLessPrice");
		q.setParameter(1, 10);
		
		List<Book> books = q.getResultList();
		// Returned book's id should be equal to 3	
		if (books.size() != 1 || books.get(0).getId() != 3) {
			fail("Returned book's id with a less price = " + books.get(0).getId());
		}
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testBookEntityValidation() {
		Book book = new Book();
		
//		this.tx.begin();
		this.em.persist(book);
//		this.tx.commit();
	}
	
}
