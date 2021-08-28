package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MockBookService implements BookService{

    private List<Book> bookList;
    private Long nextId;

    public MockBookService() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        bookList.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        bookList.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }


    @Override
    public List<Book> getBooks() {
        return bookList;
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        bookList.add(book);
    }

    @Override
    public Optional<Book> get(Long id) {
        return bookList.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }
}
