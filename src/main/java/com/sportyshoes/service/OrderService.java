package com.sportyshoes.service;

import com.sportyshoes.model.Orders;
import com.sportyshoes.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;


    public String saveOrder(Orders order) {
        orderRepository.save(order);
        return "Order placed successfully!";
    }

    public List<Orders> findAllOrders() {
        return orderRepository.findAll();
    }

    public List<Orders> getOrdersByDate(LocalDate date) {
        return orderRepository.findByOdate(date);
    }

}
