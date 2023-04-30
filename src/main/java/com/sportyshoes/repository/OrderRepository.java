package com.sportyshoes.repository;

import com.sportyshoes.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findByOdate(LocalDate odate);
}
