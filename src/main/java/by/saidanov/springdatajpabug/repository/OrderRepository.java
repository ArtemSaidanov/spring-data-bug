package by.saidanov.springdatajpabug.repository;

import by.saidanov.springdatajpabug.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author A.Saidanov
 * @since 27/11/17.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
