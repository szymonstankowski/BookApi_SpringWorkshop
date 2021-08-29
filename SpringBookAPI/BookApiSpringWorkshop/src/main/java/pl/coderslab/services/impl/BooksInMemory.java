package pl.coderslab.services.impl;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.BookService;
import pl.coderslab.exceptions.BadResourceException;
import pl.coderslab.exceptions.ResourceNotFoundException;
import pl.coderslab.services.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Primary
public class BooksInMemory implements BookService {

    private static final Logger log = (Logger) LoggerFactory.getLogger(BooksInMemory.class);
    private static AtomicLong nextId = new AtomicLong(3L);

    private final List<Book> list;

    public BooksInMemory() {
        log.info("Tworzenie listy ksiazek...");
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
        log.info("Utworzono liste ksiazke: {}", list);
    }


    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public Book getBookById(Long bookId) {
        log.debug("Dodawanie ksiazki...");

        Book foundBook = list.stream()
                .filter(book -> book.getId().equals(bookId))
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new);
        log.debug("Znaleziona ksiazka: {}", foundBook);
        return foundBook;
    }

    @Override
    public  Book addBook(Book bookToAdd) {
        log.debug("Dodawanie ksiazki {}", bookToAdd);
        if (bookToAdd.getTitle()==null || bookToAdd.getTitle().isBlank()){
            throw new BadResourceException("Book must have a title");
        }
        bookToAdd.setId(nextId.incrementAndGet());
        log.debug("Usta;pme od dla ksiazki: {}",bookToAdd.getId());
        list.add(bookToAdd);
        return bookToAdd;
    }

    @Override
    public void deleteBookById(Long bookId) {
        log.debug("Liczba ksiazek przed usunieciem: {}", list.size());

        list.stream()
                .filter(book -> book.getId().equals(bookId))
                .findFirst()
                .ifPresentOrElse(
                        list::remove,
                        () -> {
                            throw new ResourceNotFoundException();
                        });
        log.debug("Liczba ksiazek po usunieciu {}", list.size());
    }

    @Override
    public void updadeBook(Book updateBook) {
        log.debug("Aktualizacja ksiazki: {}", updateBook);
        log.debug("Liczba ksiazek przed aktualizacja: {}", list.size());

        list.stream()
                .filter(book -> book.getId().equals(updateBook.getId()))
                .map(list::indexOf)
                .findFirst()
                .ifPresentOrElse(
                        index -> list.set(index, updateBook),
                        () -> {
                            throw new ResourceNotFoundException();
                        });
        log.debug("Lista ksiazek po aktualizacji: {}", list.size());
    }


}
