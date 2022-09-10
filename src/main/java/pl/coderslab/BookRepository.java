package pl.coderslab;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;


@Primary
public interface BookRepository extends JpaRepository<Book, Long> {


}
