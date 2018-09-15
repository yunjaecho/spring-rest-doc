package yunjae.cho.springrestdoc.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedAt;
}
