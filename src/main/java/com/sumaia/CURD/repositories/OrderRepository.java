package com.sumaia.CURD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumaia.CURD.entities.Order;

public interface OrderRepository extends JpaRepository<Order , Long> {

    
}
