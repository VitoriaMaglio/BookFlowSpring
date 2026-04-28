package repository;

import entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projection.BookSimpleProjection;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b.id as id, b.title as title FROM Book b")
    Page<BookSimpleProjection> findSimpleBooks(Pageable pageable);

    Page<Book> findByRatingGreaterThanEqual(Double rating, Pageable pageable);

    @Query("""
    SELECT b FROM Book b
    JOIN b.authors a
    WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))
""")
    Page<Book> findByAuthorName(@Param("name") String name, Pageable pageable);


}
