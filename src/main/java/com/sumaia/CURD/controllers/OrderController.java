package com.sumaia.CURD.controllers;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumaia.CURD.entities.Order;
import com.sumaia.CURD.models.OrderRequest;
import com.sumaia.CURD.repositories.OrderRepository;
import com.sumaia.CURD.repositories.UserRepository;

@RestController
//@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/orderpost")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest)
    {
        Optional<com.sumaia.CURD.entities.User> userOptional = userRepository.findById(orderRequest.getUserId());
    
    if (userOptional.isPresent())
    {
        User user = (User) userOptional.get();

        Order order = new Order();
        order.setProductID(orderRequest.getProductID());
        order.setProductQuantity(orderRequest.getQuantity());
        order.setUnitPrice(orderRequest.getUnitPrice());
        order.setUser(user);

        orderRepository.save(order);

        return ResponseEntity.ok("Order added successfully");
    }
    else
    {
        return ResponseEntity.status(404).body("User not found");
    }
    }


    @GetMapping("/orderId")
    public ResponseEntity<?> getOrder(@PathVariable Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            return ResponseEntity.ok(order.get());
        } else {
            return ResponseEntity.status(404).body("Order not found");
        }
    }


    @DeleteMapping("/orderdl")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            return ResponseEntity.ok("Order deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Order not found");
        }
    }
}
