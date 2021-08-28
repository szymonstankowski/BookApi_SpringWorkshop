package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookService {

    List<Book> getBooks();
}
