package com.aberimen.swagger.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class BookController {
    
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookService.getBooks();
	}
	
	@PostMapping("/books")
	public Book newBook(@RequestBody Book book) {
		return bookService.save(book);
	}
	
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable String id, @RequestBody Book book) {
		return bookService.update(id,book);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable String id) {
		 bookService.delete(id);
	}

}
