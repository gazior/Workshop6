package pl.coderslab;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockBookService implements BookService {


    private List<Book> list = new ArrayList<>();


    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book("9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book("9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book("9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> showAll() {
        return list;
    }

    public void addBook(Book book) {
        list.add(book);
    }

    public void deleteBook(Book book) {
        list.remove(book);
    }

    public Optional<Book> findById(Long id) {

        return list.stream().filter(book -> book.getId().equals(id)).findFirst();


/*       for (Book book : list) {
            if (book.getId() == id) {
                return book;
            }

        }
        return null; */
    }


    public void updateBook(Book book, Long id) {

        for (Book scanBook : list) {
            if (book.getId() == id) {
                int index = list.indexOf(book);
                list.set(index, book);
            }
        }
    }
}
