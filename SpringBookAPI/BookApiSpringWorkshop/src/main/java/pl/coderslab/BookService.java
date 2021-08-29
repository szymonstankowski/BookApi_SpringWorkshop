package pl.coderslab;


import pl.coderslab.services.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    Book getBookById(Long id);

    Book addBook(Book book);

    void deleteBookById(Long id);

    void updadeBook(Book updateBook);



}
