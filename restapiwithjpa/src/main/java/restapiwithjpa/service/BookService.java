package restapiwithjpa.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restapiwithjpa.dao.BookRepository;
import restapiwithjpa.entities.Book;


@Service
public class BookService {
	
//	private static List<Book> list= new ArrayList<>();
//	
//	static {
//		list.add(new Book(123,"Java Complete Reference","MKO"));
//		list.add(new Book(456,"Spring Complete Guidence","TYH"));
//		list.add(new Book(789,"Rest Api ","Youtube"));
//		list.add(new Book(963,"Python Complete","PLM"));
//		
//	}
	@Autowired
	private BookRepository bookRepository;
	
	
	// get All Book
	public List<Book> getAllBook(){
		// return list;
		List<Book> list=(List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	// get single Book by id
	public Book getBookById(int id) {
		Book book =null;
		try {
//		    book= list.stream().filter(e->e.getId()==id).findFirst().get();
			book = this.bookRepository.findById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	// adding the Book
	public Book addBook(Book b) {
//		list.add(b);
//		return b;
		Book result=this.bookRepository.save(b);
		return result;
		
	}
    // Deleting Book in the Server
	public void deleteBook(int bid) {
		
//		list.stream().filter(book->{
//			if(book.getId()!= bid)
//				return true;
//			else
//				return false;
//		}).collect(Collectors.toList());
		
//		list=list.stream().filter(e->e.getId()!=bid).
//		collect(Collectors.toList());
		
		this.bookRepository.deleteById(bid);
		
		
		
	}
   // Update Book in the list
	public void updateBook(Book book, int bookId) {
//		list=list.stream().map(b->{
//			if(b.getId() == bookId)
//			{
//				b.setName(book.getName());
//				b.setTitle(book.getTitle());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(bookId);
		this.bookRepository.save(book);
		
	}
	
	
	
	
	
	
	
	
	

}
