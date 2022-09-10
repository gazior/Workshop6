package pl.coderslab;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> showAll();

    void addBook(Book book);

    void deleteBook(Book book);

    Optional<Book> findById(Long id);

    void updateBook(Book book, Long id);

}
