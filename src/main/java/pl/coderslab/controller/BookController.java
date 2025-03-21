package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookNotFoundException;
import pl.coderslab.model.BookRequest;
import pl.coderslab.model.BookService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public String addBook(@RequestBody Book book) {
        bookService.add(book);
        return book.toString() + " added";
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.get(id).orElse(null);
    }

    @PutMapping
    public String updateBook(@RequestBody Book book) {
        try {
            bookService.update(book);
            return book.toString() + " updated";
        } catch (BookNotFoundException e) {
            return e.getMessage();
        }

    }


}

