package com.aberimen.swagger.book;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService {
	
	private BookRepository bookRepository;

	public List<Book> getBooks() {
	
		return bookRepository.findAll();
	}

	public Book save(Book book) {
		
		return bookRepository.save(book);
	}

	public Book update(String id, Book newBook) {
		
		Optional<Book> inDb = bookRepository.findById(id);
		
		if(inDb.isPresent()) {
			inDb.map( book -> {
				book.setTitle(newBook.getTitle());
				book.setAuthor(newBook.getAuthor());
				book.setPage(newBook.getPage());
				
				return bookRepository.save(book);
			}).get();
		}
		
		return null;
	}

	public void delete(String id) {
	
		 bookRepository.deleteById(id);
	}
	
}
