package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order implements Serializable {

    private Integer orderId;
    private Integer clientId;
    private LocalDateTime orderDate;
    private Double orderPrice;
    private List<MenuItem> productsOrdered;

    public Order(Integer orderId, Integer clientId, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(clientId, order.clientId) && Objects.equals(orderDate, order.orderDate);
    }

    public List<MenuItem> getProductsOrdered() {
        return productsOrdered;
    }

    public void setProductsOrdered(List<MenuItem> productsOrdered) {
        this.productsOrdered = productsOrdered;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, clientId, orderDate);
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }
}
