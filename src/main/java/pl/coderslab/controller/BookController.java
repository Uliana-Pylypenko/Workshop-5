package pl.coderslab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {

    @RequestMapping("/helloBook")
    public Book helloBook() {
        Book book = new Book(1, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
        return book;
    }
}

