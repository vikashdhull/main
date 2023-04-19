package com.example.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepository;
import com.example.demo.repo.Utilities;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
    private BookRepository bookRepository;
	
	

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
    
    // fetch all title column value
    @Cacheable(value = "books")
    @GetMapping("/titles")
    public List<String> getAllTitles() {
        return bookRepository.findAllTitles();
    }
    
    @GetMapping("/mixResult")
    public ResponseEntity<List<HashMap<String, String>>> getResult() {
    	List<Object[]> value = bookRepository.getMixResult();
    	List<String> key = Arrays.asList("id","name","id","author","title","table3_id","table3_city");
    	List<HashMap<String, String>> result = Utilities.convertToHashMap(value,key);
    	return new ResponseEntity<>(result, HttpStatus.OK);
    	
    }
    
    
 /*   @GetMapping("/query2")
    public void queryFromOtherDB2() {
    	
    	try (Connection connection1 = dataSource1().getConnection();
    		     Connection connection2 = dataSource2().getConnection()) {
    		    Statement statement = connection1.createStatement();
    		    ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
    		    while(resultSet.next()) {
    		    	
    		    	System.out.println(resultSet.getString("title"));
    		    	System.out.println(resultSet.getString("author"));
    		    }

    		    //process the result set
    		} catch (SQLException e) {
    		    // handle exception
    		}

    }  */
}
