package com.example.Security.service;

import com.example.Security.domain.OrderType;
import com.example.Security.modal.Coin;
import com.example.Security.modal.Order;
import com.example.Security.modal.OrderItem;
import com.example.Security.modal.User;

import java.util.List;

public interface OrderService {
    Order createOrder(User user, OrderItem orderItem, OrderType orderType) throws Exception;
    Order getOrderById(Long orderId) throws Exception;
    List<Order> getAllOrdersOfUser(Long userId, OrderType orderType, String assetSymbol) throws Exception;
    Order processOrder(Coin coin, double quantity, OrderType orderType, User user) throws Exception;
}
