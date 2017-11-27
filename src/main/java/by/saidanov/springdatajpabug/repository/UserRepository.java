package by.saidanov.springdatajpabug.repository;

import by.saidanov.springdatajpabug.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author A.Saidanov
 * @since 27/11/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(value = "User.Orders", type = EntityGraph.EntityGraphType.LOAD)
    List<User> findFirst3ByAge(Integer age);

    List<User> findFirst2ByAge(Integer age);
}
