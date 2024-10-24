package com.example.demo.controller;

import com.example.demo.model.CustomerOrder;
import com.example.demo.model.OrderItem;
import com.example.demo.model.Discount;
import com.example.demo.model.Payment;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public CustomerOrder createOrder(@RequestBody CustomerOrder order) {
        return orderService.createOrder(order.getCustomerId(), order.getItems());
    }

    @PutMapping("/{id}/items")
    public void addOrderItem(@PathVariable Long id, @RequestBody OrderItem item) {
        orderService.addOrderItem(id, item);
    }

    @DeleteMapping("/{id}/items")
    public void removeOrderItem(@PathVariable Long id, @RequestBody OrderItem item) {
        orderService.removeOrderItem(id, item);
    }

    @PutMapping("/{id}/discount")
    public void applyDiscount(@PathVariable Long id, @RequestBody Discount discount) {
        orderService.applyDiscount(id, discount);
    }

    @PostMapping("/{id}/payment")
    public void processOrderPayment(@PathVariable Long id, @RequestBody Payment payment) {
        orderService.processOrderPayment(id, payment);
    }

    @PutMapping("/{id}/deliveryStatus")
    public void updateDeliveryStatus(@PathVariable Long id, @RequestParam String newStatus) {
        orderService.updateDeliveryStatus(id, newStatus);
    }

    @GetMapping("/{id}")
    public CustomerOrder getOrderDetails(@PathVariable Long id) {
        return orderService.getOrderDetails(id);
    }
}
