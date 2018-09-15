package yunjae.cho.springrestdoc;

import org.springframework.data.jpa.repository.JpaRepository;
import yunjae.cho.springrestdoc.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
