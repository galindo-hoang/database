package nn.estore.jpa.service;

import nn.estore.jpa.entity.Order;
import nn.estore.jpa.entity.OrderState;
import nn.estore.jpa.entity.User;
import nn.estore.service.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@Transactional
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    OrderStateService orderStateService;

    @Test
    void purchase() {
        User user = userService.findByUsername("BOLID");
        OrderState orderState = orderStateService.findById(2);

        Order order = new Order();
        order.setCustomer(user);
        order.setAmount(1.0);
        order.setCreateDate(new Date());
        order.setOrderState(orderState);
        List<ShoppingCartService.CartItem> list = new ArrayList<>();
        ShoppingCartService.CartItem cartItem = new ShoppingCartService.CartItem();

        cartItem.setDiscount(0.0);
        cartItem.setQuantity(9);
        cartItem.setPrice(0.0);
        cartItem.setId(1060);
        list.add(cartItem);
        orderService.purchase(order,list);

        List<Order> listOrderPurchase = orderService.findByCustomer(user);
        assertThat(listOrderPurchase, is(List.of(order)));

    }

    @Test
    void findByCustomer() {
        User usr = userService.findByUsername("BOLID");
        List<Order> list = orderService.findByCustomer(usr);
        assertThat(list, is(notNullValue()));
    }

    @Test
    void findById() {
        Order order = orderService.findById(10676L);
        assertThat(order, is(notNullValue()));
    }

    @Test
    void findAll() {
        List<Order> list = orderService.findAll();
        assertThat(0, is(not(list.size())));
    }

    @Test
    void deleteById() {
        Order order = orderService.findById(10677L);
        assertThat(order, is(notNullValue()));
        orderService.deleteById(10677L);
        assertThat(orderService.findById(10677L),is(nullValue()));
    }

    @Test
    void update() {
        Order order = orderService.findById(10678L);
        assertThat(order, is(notNullValue()));
        order.setAmount(100.0);
        orderService.update(order);
        assertThat(orderService.findById(10678L).getAmount(), is(100.0));
    }

    @Test
    void findByOrderState() {
        OrderState orderState = orderStateService.findById(6);
        List<Order> list = orderService.findByOrderState(orderState);
        assertThat(0, is(not(list.size())));
    }
}