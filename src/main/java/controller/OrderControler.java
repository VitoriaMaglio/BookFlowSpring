package controller;

import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import projection.OrderSummaryProjection;
import repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderControler {
    @Autowired
    private OrderRepository repo;

    @GetMapping
    public Page<Order> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @GetMapping("/customer")
    public Page<Order> byCustomer(@RequestParam Long customerId, Pageable pageable) {
        return repo.findByCustomerId(customerId, pageable);
    }

    @GetMapping("/summary")
    public Page<OrderSummaryProjection> summary(Pageable pageable) {
        return repo.findOrderSummary(pageable);
    }

    @GetMapping("/search/book")
    public Page<Order> findByBook(
            @RequestParam Long bookId,
            Pageable pageable) {

        return repo.findOrdersByBook(bookId, pageable);
    }

}
