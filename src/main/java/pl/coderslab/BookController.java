package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String bookAdd(Model model) {
        model.addAttribute("book", new Book());
        return "bookadd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String showAddBook(Book book, Model model) {
        model.addAttribute("book", book);
        bookService.addBook(book);
        return "showAddBook";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showAllBook(Model model) {
        List<Book> books = bookService.showAll();
        model.addAttribute("books", books);
        return "showAllBooks";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id, Model model) {
        bookService.deleteBook(bookService.findById(id).get());
        model.addAttribute("books", bookService.showAll());
        return "showAllBooks";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String updateBook(Model model, @PathVariable Long id) {
        Book book = bookService.findById(id).get();
        model.addAttribute("book", book);
        return "editBook";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditBook(Book book, Model model) {
        bookService.updateBook(book, book.getId());
        model.addAttribute("books", bookService.showAll());
        return "showAllBooks";

    }


    @RequestMapping("/")
    public String hello() {
        return "index";
    }
}
