package com.example.rest.ctrl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.rest.ctrl.entity.Book;
import com.example.rest.service.RestService;
import com.example.rest.service.Repository.RestRepository;


//@SpringJUnitConfig
@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class CtrlTest {
	@Mock
    private RestRepository bookRepository;

    @InjectMocks
    private RestService bookService;

    @InjectMocks
    private RestCtrl bookController;
    
//    @Before(value = "")
//    public void setUp() {
//    	bookService=mock(RestService.class);
//    	bookController=new RestCtrl(bookService);
//    }
//    @Test
//    public void updateTest() {
//    	   // Prepare test data
//        long id = 1L;
//        Book existingBook = new Book(id, "Existing Title", "Existing Author", 2020);
//        Book updatedBook = new Book(id, "Updated Title", "Updated Author", 2021);
//
//    	when(bookService.getBookById(id)).thenReturn(existingBook);
//    	when(bookService.saveAllBooks(existingBook)).thenReturn(updatedBook);
//        // Call the method
//        ResponseEntity<Book> response = bookController.updateBook(id, updatedBook);
//
//        // Verify the response
//    	 assertNotNull(response);
//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         assertEquals(updatedBook, response.getBody());
//    }
    
    @Test
    public void getBooks() {
    	List<Book> mcBook=new ArrayList<>();
    	mcBook.add(new Book(1L, "Book 1", "Author 1"));
    	mcBook.add(new Book(2L, "Book 2", "Author 2"));
    	when(bookRepository.findAll()).thenReturn(mcBook);
    	 List<Book> returnedBooks = bookService.getAllBooks();

         assertEquals(2, returnedBooks.size());
    }
    @Test
    public void testCreateBook() {
        Book mockBook = new Book(1L, "Book 1", "Author 1");
        when(bookRepository.save(mockBook)).thenReturn(mockBook);

        Book returnedBook = bookService.saveAllBooks(mockBook);

       // assertEquals("Book 1", returnedBook.getTitle());
       // assertEquals("Author 1", returnedBook.getAuthor());
    }

//    @Test
//    public void testUpdateBook() {
//        Book mockBook = new Book(1L, "Book 1", "Author 1");
//        when(bookRepository.existsById(1L)).thenReturn(true);
//        when(bookRepository.save(mockBook)).thenReturn(mockBook);
//
//        Book updatedBook = bookService.updateBook(1L, mockBook);
//
//        assertEquals("Book 1", updatedBook.getTitle());
//        assertEquals("Author 1", updatedBook.getAuthor());
//    }

    @Test
    public void testDeleteBook() {
        when(bookRepository.existsById(1L)).thenReturn(true);

        bookService.deleteById(1L);

        // Verify that deleteById method was called once
        verify(bookRepository, times(1)).deleteById(1L);
    }
    
 

}
