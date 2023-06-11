package com.codingapi.crankycode.serivce;

import com.codingapi.crankycode.command.OrderCommand;
import com.codingapi.crankycode.domain.Order;
import com.codingapi.crankycode.domain.Product;
import com.codingapi.crankycode.domain.User;
import com.codingapi.crankycode.repository.OrderRepository;
import com.codingapi.crankycode.repository.ProductRepository;
import com.codingapi.crankycode.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OrderExecutor {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;


    public void createOrder(OrderCommand.CreateCommand command){
        User user = userRepository.getUserByName(command.getUsername());
        Product product = productRepository.getProductByName(command.getProductName());
        Order order = new Order(user, List.of(product));
        order.pay();
        orderRepository.save(order);
    }



}
