package pl.coderslab;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Primary
@Transactional
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;
    private final EntityManager entityManager;


    public JpaBookService(BookRepository bookRepository, EntityManager entityManager) {
        this.bookRepository = bookRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> showAll() {


        return bookRepository.findAll();
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Optional<Book> findById(Long id) {


        return bookRepository.findById(id);
    }

    @Override
    public void updateBook(Book book,Long id) {
        entityManager.merge(book);
    }
}
