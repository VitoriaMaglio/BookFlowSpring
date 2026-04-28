package service;

import dto.OrderCreateDTO;
import entity.Book;
import entity.Customer;
import entity.Order;
import entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import repository.BookRepository;
import repository.CustomerRepository;
import repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;

public class OrderService {

    @Autowired private OrderRepository orderRepo;
    @Autowired private CustomerRepository customerRepo;
    @Autowired
    private BookRepository bookRepo;

    public Order create(OrderCreateDTO dto) {

        Customer customer = customerRepo.findById(dto.getCustomerId())
                .orElseThrow();

        Order order = new Order();
        order.setCustomer(customer);
        order.setCreatedAt(LocalDateTime.now());

        List<OrderItem> items = dto.getItems().stream().map(i -> {

            Book book = bookRepo.findById(i.getBookId()).orElseThrow();

            OrderItem oi = new OrderItem();
            oi.setBook(book);
            oi.setQuantity(i.getQuantity());
            oi.setPrice(book.getPrice());
            oi.setOrder(order);

            return oi;

        }).toList();

        order.setItems(items);

        return orderRepo.save(order);
    }
}
