package com.example.rest.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.ctrl.entity.Book;
import com.example.rest.service.RestService;

@RestController
//@RequestMapping("/books")
public class RestCtrl {
    
	@Autowired
	private RestService service;
	
	public RestCtrl(RestService bookService) {
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping
	public List<Book> getAllBooks(Book book){
		return service.getAllBooks();
		
		
	}
	  @GetMapping("/{id}")
	    public Book getBookById(@PathVariable Long id) {
	        return service.getBookById(id);
	    }
	
	@PostMapping("/savebook")
	public Book saveBooks(@RequestBody Book book){
		return service.saveAllBooks(book);
		
	}
	
	@DeleteMapping("/delete{id}")
	public void deleteBook(@PathVariable Long id) {
		
	 service.deleteById(id);
	
	}
	//update
	 @PutMapping("{id}/update")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Book existingBook = service.getBookById(id);

        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setYear(updatedBook.getYear());

            Book savedBook = service.saveAllBooks(existingBook);
            return new ResponseEntity<>(savedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	
	
}
