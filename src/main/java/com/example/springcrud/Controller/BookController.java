package com.example.springcrud.Controller;

import com.example.springcrud.Model.Book;
import com.example.springcrud.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    // Get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            List<Book> books = new ArrayList<>(bookRepo.findAll());

            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> bookData = bookRepo.findById(id);

        return bookData.map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add new book
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        try {
            Book savedBook = bookRepo.save(book);
            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update book
    @PatchMapping("/update/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> bookData = bookRepo.findById(id);

        if (bookData.isPresent()) {
            Book existingBook = bookData.get();

            if (book.getAuthor() != null) {
                existingBook.setAuthor(book.getAuthor());
            }

            if (book.getTitle() != null) {
                existingBook.setTitle(book.getTitle());
            }

            Book updatedBook = bookRepo.save(existingBook);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete book
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable Long id) {
        try {
            bookRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
