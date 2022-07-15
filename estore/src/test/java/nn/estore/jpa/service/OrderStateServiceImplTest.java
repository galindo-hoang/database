package nn.estore.jpa.service;
import nn.estore.jpa.entity.OrderState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@Transactional
class OrderStateServiceImplTest {
    @Autowired
    OrderStateService orderStateService;

    @Test
    void findById() {
        OrderState orderState = orderStateService.findById(6);
        assertThat(orderState, is(notNullValue()));
    }

    @Test
    void findAll() {
        List<OrderState> orderStateList = orderStateService.findAll();
        assertThat(0, is(not(orderStateList.size())));
    }
}