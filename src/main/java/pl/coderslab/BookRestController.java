package pl.coderslab;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController( BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping(value = "/books")
    public List<Book> showBooks() {
        return bookService.showAll();
    }

    @PostMapping(value = "/books")
    public String addBooks(@RequestBody Book book) {

        bookService.addBook(book);
        return "Dodano: " + book.getId();
    }

    @GetMapping(value = "/books/{id}")
    @ResponseBody
    public Book findbyId(@PathVariable Long id) {

        return bookService.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Brak danych");
        });

    }

    @DeleteMapping(value = "/books/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {

        Book book = bookService.findById(id).get();
        bookService.deleteBook(book);

        return "Usunięto";
    }

    @PutMapping(value = "/books")
    @ResponseBody
    public String updateBook(@RequestBody Book book) {


        bookService.updateBook(book, book.getId());

        return "Zamieniono ID: " + book.getId();
    }
}


