package repository;

import entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projection.OrderSummaryProjection;

import java.time.LocalDateTime;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByCustomerId(Long customerId, Pageable pageable);

    Page<Order> findByCreatedAtBetween(
            LocalDateTime start,
            LocalDateTime end,
            Pageable pageable
    );

    @Query("""
        SELECT o.id as id, o.createdAt as createdAt, c.name as customerName
        FROM Order o JOIN o.customer c
    """)
    Page<OrderSummaryProjection> findOrderSummary(Pageable pageable);

}
