package pl.coderslab;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
  //  @ResponseBody
    public List<Book> getList() {
        return bookService.getBooks();
    }



    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){
        return this.bookService.get(id).orElseThrow(()->{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }
    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        bookService.delete(id);
    }





}
