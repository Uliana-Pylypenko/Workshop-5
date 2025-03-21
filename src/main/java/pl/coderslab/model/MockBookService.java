package pl.coderslab.model;

import java.util.ArrayList;
import java.util.List;

public class MockBookService {
    private List<Book> list;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1, "978-3-16-148410-0", "Clean Code", "Robert C. Martin", "Pearson", "Programming"));
        list.add(new Book(2, "978-0-321-35668-0", "Design Patterns", "Erich Gamma", "Addison-Wesley", "Software Engineering"));
        list.add(new Book(3, "978-0-596-52068-7", "Java Concurrency in Practice", "Brian Goetz", "O'Reilly Media", "Programming"));
        list.add(new Book(4, "978-1-491-91465-6", "Effective Java", "Joshua Bloch", "Addison-Wesley", "Programming"));
        list.add(new Book(5, "978-1-449-39317-0", "Head First Design Patterns", "Eric Freeman", "O'Reilly Media", "Software Engineering"));
        list.add(new Book(6, "978-0-134-35497-5", "Introduction to Algorithms", "Thomas H. Cormen", "MIT Press", "Algorithms"));
        list.add(new Book(7, "978-0-201-63361-0", "The Art of Computer Programming", "Donald E. Knuth", "Addison-Wesley", "Programming"));
        list.add(new Book(8, "978-0-13-235088-4", "Agile Software Development", "Robert C. Martin", "Prentice Hall", "Software Engineering"));
        list.add(new Book(9, "978-0-262-03384-8", "Structure and Interpretation of Computer Programs", "Harold Abelson", "MIT Press", "Programming"));
        list.add(new Book(10, "978-0-596-51774-8", "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "Addison-Wesley", "Programming"));
    }

}
