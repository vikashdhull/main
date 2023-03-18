package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    
    @Query("SELECT b.title FROM Book b")
    List<String> findAllTitles();
    
    @Procedure(name = "square(4,5)")
    int findBooksByAuthor();
    
    @Query(value = "SELECT * FROM table2 LEFT JOIN book ON table2.id = book.id INNER JOIN table3 ON table3.table3_id=book.id WHERE table2.name = 'sunny'", nativeQuery = true)
    public List<Object[]> getMixResult();
}
