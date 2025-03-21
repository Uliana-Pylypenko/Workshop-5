package pl.coderslab.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class MockBookService implements BookService {
    private List<Book> list;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "978-3-16-148410-0", "Clean Code", "Robert C. Martin", "Pearson", "Programming"));
        list.add(new Book(2L, "978-0-321-35668-0", "Design Patterns", "Erich Gamma", "Addison-Wesley", "Software Engineering"));
        list.add(new Book(3L, "978-0-596-52068-7", "Java Concurrency in Practice", "Brian Goetz", "O'Reilly Media", "Programming"));
        list.add(new Book(4L, "978-1-491-91465-6", "Effective Java", "Joshua Bloch", "Addison-Wesley", "Programming"));
        list.add(new Book(5L, "978-1-449-39317-0", "Head First Design Patterns", "Eric Freeman", "O'Reilly Media", "Software Engineering"));
        list.add(new Book(6L, "978-0-134-35497-5", "Introduction to Algorithms", "Thomas H. Cormen", "MIT Press", "Algorithms"));
        list.add(new Book(7L, "978-0-201-63361-0", "The Art of Computer Programming", "Donald E. Knuth", "Addison-Wesley", "Programming"));
        list.add(new Book(8L, "978-0-13-235088-4", "Agile Software Development", "Robert C. Martin", "Prentice Hall", "Software Engineering"));
        list.add(new Book(9L, "978-0-262-03384-8", "Structure and Interpretation of Computer Programs", "Harold Abelson", "MIT Press", "Programming"));
        list.add(new Book(10L, "978-0-596-51774-8", "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "Addison-Wesley", "Programming"));
    }

    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public Optional<Book> get(Long id) {
        return list.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    @Override
    public void add(Book book) {
        Optional<Book> maxIdBook = list.stream().max(Comparator.comparingLong(Book::getId));
        if (maxIdBook.isPresent()) {
            book.setId(maxIdBook.get().getId() + 1L);
        }
        list.add(book);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Book book) {
        Long id = book.getId();
        Optional<Book> bookToUpdate = get(id);
        if (bookToUpdate.isPresent()) {
            int index = list.indexOf(bookToUpdate.get());
            list.set(index, book);
        } else {
            throw new BookNotFoundException("Book with id " + book.getId() + " not found");
        }

    }

}
