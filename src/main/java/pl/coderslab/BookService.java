package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface BookService {

    List<Book> getBooks();

    void addBook(Book book);

    Optional<Book> get(Long id);

}
