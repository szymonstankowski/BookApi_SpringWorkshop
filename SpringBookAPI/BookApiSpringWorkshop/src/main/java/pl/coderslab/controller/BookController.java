package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.BookService;
import pl.coderslab.services.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

private final BookService bookService;
public BookController(BookService bookService){
    this.bookService=bookService;
}

    // GET localhost:8080/books
    @GetMapping
    public List<Book> getBooks(){
    return bookService.getBooks();
    }

    // POST localhost:8080/books
    @PostMapping
    public Book addBook(@RequestBody Book book){
    return bookService.addBook(book);
    }

    // GET localhost:8080/books/51
    @GetMapping("/{bookId:\\d+}")
    public Book getBookById(@PathVariable Long bookId){
    return bookService.getBookById(bookId);
    }

    // PUT localhost:8080/books/51
    // {
    // "id" : 12,

    @PutMapping("{bookId:\\d+}")
    public Book updateBook(@PathVariable Long bookId, @RequestBody Book book){
    book.setId(bookId);
    bookService.updadeBook(book);
    return book;
    }

    // DELETE localhost:8080/books/51
    @DeleteMapping("{bookId:\\d+}")
    public void deleteBook(@PathVariable Long bookId){
    bookService.deleteBookById(bookId);
    }



}
