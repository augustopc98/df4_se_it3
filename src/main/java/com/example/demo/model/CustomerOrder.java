package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate ID
    private Long id;

    private Long customerId;
    private Date orderDate;
    private String deliveryStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerOrder")
    private List<OrderItem> items;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerOrder")
    private List<Payment> payments;

    public CustomerOrder() {}

    public CustomerOrder(Long id, Long customerId, Date orderDate, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.items = items;
        this.deliveryStatus = "Pending";
    }


    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void updateDeliveryStatus(String status) {
        this.deliveryStatus = status;
    }

    public void addOrderItem(OrderItem item) {
        this.items.add(item);
    }

    public void removeOrderItem(OrderItem item) {
        this.items.remove(item);
    }

    public BigDecimal calculateTotal() {
        return items.stream()
                .map(OrderItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void applyDiscount(Discount discount) {
        BigDecimal total = calculateTotal();
        BigDecimal discountedTotal = discount.applyDiscount(total);
        // Logic to apply the discount to the total price can be extended.
    }

    public void sendForDelivery() {
        this.deliveryStatus = "Shipped";
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public List<Payment> getPayments() {
        return payments;
    }
}
