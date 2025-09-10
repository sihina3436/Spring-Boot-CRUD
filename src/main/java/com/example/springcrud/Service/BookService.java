package com.example.springcrud.Service;

import com.example.springcrud.Repo.BookRepo;

public class BookService {
    public final BookRepo bookRepository;

    public BookService(BookRepo bookRepository) {
        this.bookRepository = bookRepository;
    }



}
