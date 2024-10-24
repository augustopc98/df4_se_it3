package com.example.demo.service;

import com.example.demo.model.CustomerOrder;
import com.example.demo.model.OrderItem;
import com.example.demo.model.Discount;
import com.example.demo.model.Payment;

import java.util.List;

public interface OrderService {
    CustomerOrder createOrder(Long customerId, List<OrderItem> items);
    void addOrderItem(Long orderId, OrderItem item);
    void removeOrderItem(Long orderId, OrderItem item);
    void applyDiscount(Long orderId, Discount discount);
    void processOrderPayment(Long orderId, Payment payment);
    void updateDeliveryStatus(Long orderId, String newStatus);
    CustomerOrder getOrderDetails(Long orderId);
}
