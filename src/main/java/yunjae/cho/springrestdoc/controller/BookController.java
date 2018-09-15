package yunjae.cho.springrestdoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import yunjae.cho.springrestdoc.BookRepository;
import yunjae.cho.springrestdoc.domain.Book;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository repository;

    @GetMapping("/books")
    public List<Book> getaBooks() {
        return repository.findAll();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getaBook(@PathVariable Long id) {
        return repository.findById(id);
    }
}
