package com.example.ddd.infrastructure.order;

import com.example.ddd.domain.order.Order;
import com.example.ddd.domain.order.OrderNo;
import com.example.ddd.domain.order.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class JpaOrderRepository implements OrderRepository {

    @Override
    public Optional<Order> findById(OrderNo no) {
        return Optional.empty();
    }

    @Override
    public Order findByNumber(OrderNo no) {
        return null;
    }

    @Override
    public void save(Order order) {

    }

    @Override
    public void delete(Order order) {

    }
}
