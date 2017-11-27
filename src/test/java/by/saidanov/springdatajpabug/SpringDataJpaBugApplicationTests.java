package by.saidanov.springdatajpabug;

import by.saidanov.springdatajpabug.entity.Order;
import by.saidanov.springdatajpabug.entity.User;
import by.saidanov.springdatajpabug.repository.OrderRepository;
import by.saidanov.springdatajpabug.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaBugApplicationTests {

    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void contextLoads() {
        for (int i = 1; i < 11; i++) {
            User user = new User();
            user.setName("TestUser");
            user.setAge(10);
            List<Order> orders = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
				Order order = new Order();
				order.setName("TestOrder");
				order.setUser(user);
            }
            userRepository.save(user);
            orderRepository.save(orders);
        }

        List<User> selectWithLimit = userRepository.findFirst2ByAge(10);
        List<User> selectWithEntityGraph = userRepository.findFirst3ByAge(10);
        System.out.println(selectWithLimit.size());
        System.out.println(selectWithEntityGraph.size());

        userRepository.deleteAll();
        orderRepository.deleteAll();
    }

}
