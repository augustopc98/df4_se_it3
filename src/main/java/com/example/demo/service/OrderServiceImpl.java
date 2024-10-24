package com.example.demo.service;

import com.example.demo.model.CustomerOrder;
import com.example.demo.model.OrderItem;
import com.example.demo.model.Discount;
import com.example.demo.model.Payment;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public CustomerOrder createOrder(Long customerId, List<OrderItem> items) {
        CustomerOrder order = new CustomerOrder(null, customerId, new Date(), items);
        return orderRepository.save(order);
    }

    @Override
    public void addOrderItem(Long orderId, OrderItem item) {
        Optional<CustomerOrder> orderOptional = orderRepository.findById(orderId);
        orderOptional.ifPresent(order -> {
            order.addOrderItem(item);
            orderRepository.save(order);
        });
    }

    @Override
    public void removeOrderItem(Long orderId, OrderItem item) {
        Optional<CustomerOrder> orderOptional = orderRepository.findById(orderId);
        orderOptional.ifPresent(order -> {
            order.removeOrderItem(item);
            orderRepository.save(order);
        });
    }

    @Override
    public void applyDiscount(Long orderId, Discount discount) {
        Optional<CustomerOrder> orderOptional = orderRepository.findById(orderId);
        orderOptional.ifPresent(order -> {
            order.applyDiscount(discount);
            orderRepository.save(order);
        });
    }

    @Override
    public void processOrderPayment(Long orderId, Payment payment) {
        Optional<CustomerOrder> orderOptional = orderRepository.findById(orderId);
        orderOptional.ifPresent(order -> {
            order.getPayments().add(payment);
            orderRepository.save(order);
        });
    }

    @Override
    public void updateDeliveryStatus(Long orderId, String newStatus) {
        Optional<CustomerOrder> orderOptional = orderRepository.findById(orderId);
        orderOptional.ifPresent(order -> {
            order.updateDeliveryStatus(newStatus);
            orderRepository.save(order);
        });
    }

    @Override
    public CustomerOrder getOrderDetails(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
}
