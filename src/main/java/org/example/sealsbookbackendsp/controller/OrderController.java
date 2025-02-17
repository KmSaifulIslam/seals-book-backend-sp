package org.example.sealsbookbackendsp.controller;

import lombok.RequiredArgsConstructor;
import org.example.sealsbookbackendsp.model.Order;
import org.example.sealsbookbackendsp.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Order> placeOrder(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.placeOrder(userId));
    }

    @GetMapping("/test")
    public String test() {
        return "test response .....";
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getUserOrders(userId));
    }
}
