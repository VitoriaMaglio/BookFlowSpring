package com.api.livraria.repository;

import com.api.livraria.entity.Book;
import com.api.livraria.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query("""
        SELECT oi.book
        FROM OrderItem oi
        GROUP BY oi.book
        HAVING AVG(oi.price) > :avgPrice
    """)
    List<Book> findBooksWithAvgPriceGreaterThan(@Param("avgPrice") BigDecimal avgPrice);

}
