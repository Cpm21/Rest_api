package com.example.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.rest.ctrl.entity.Book;
import com.example.rest.service.Repository.RestRepository;

@Service
public class RestService {

	
	@Autowired
	private RestRepository repository;
	
	 public RestService(RestRepository repository) {
	        this.repository = repository;
	    }
	//get all the value
	public List<Book> getAllBooks() {
		return repository.findAll();
	}
	
	
	//save
	public Book saveAllBooks(Book book){
		return  repository.save(book);
		
	}
	
	//Delete
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
//	
//	//update
//	public Book updateBook(long id,Book updatedBook) {
//		
//		Book existingBook = repository.findById(id).orElseThrow();
//				
//				
//				existingBook.setTitle(updatedBook.getTitle());
//        existingBook.setAuthor(updatedBook.getAuthor());
//        existingBook.setYear(updatedBook.getYear());
//				
//		 return repository.save(existingBook);
//		
//	}


	private Object NotFoundException(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public Book getBookById(Long id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

	
   

//    public void saveBook() {
//        Book book1 = new Book();
//        book1.setId(1L);
//        book1.setAuthor("thiru133");
//        book1.setTitle("kural1330");
//        book1.setYear(2000);
//        System.out.println(book1.getAuthor());
//
//        try {
//            repository.save(book1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
