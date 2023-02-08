package restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import restapi.entities.Book;
import restapi.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	// get all Book Handler
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
		
//		Book book= new Book();
//		book.setId(123);
//		book.setName("Java With Data Structure");
//		book.setTitle("By ABCD");
		
//		List<Book> allBook = this.bookService.getAllBook();
//		return allBook;
		System.out.println("starting point");
		List<Book> list = bookService.getAllBook();
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
		
	}
	//get Book By Single Book Handler
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = this.bookService.getBookById(id);
		if(book == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
		
	}
	// put Book in the server
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
//		Book b = this.bookService.addBook(book);
//		return b;
	   Book b= null;
	   try {
		   b=this.bookService.addBook(b);
		   System.out.println(b);
		   return ResponseEntity.status(HttpStatus.CREATED).build();
	   }
	   catch (Exception e) {
		// TODO: handle exception
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	}
	// Delete Book from Server
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId)
	{
		try{
			this.bookService.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	// Update Book Handler
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		try {
			this.bookService.updateBook(book,bookId);
			return ResponseEntity.ok().body(book);
		}
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.
					status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	

}
