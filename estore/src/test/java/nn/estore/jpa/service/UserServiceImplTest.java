package nn.estore.jpa.service;

import nn.estore.jpa.entity.Product;
import nn.estore.jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * nn.estore.jpa.service
 * Created by Admin
 * Date 7/16/2022 - 3:41 PM
 * Description: ...
 */
@SpringBootTest
@Transactional
class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    void create() {
        userService.create(new User("user12333","123456"));
        assertThat(userService.existByUsername("user12333"), is(true));
    }

    @Test
    void existByUsername() {
        boolean isExist= userService.existByUsername("user1");
        assertThat(isExist, is(true));
    }

    @Test
    void findByUsername() {
        User user =new User("user12333","123456");
        userService.create(user);
        User isExist=  userService.findByUsername(user.getUsername());
        assertThat(isExist,is(notNullValue(User.class)));
        assertThat(isExist.getUsername(), is("user12333"));
    }

    @Test
    void update() {
        User oldUser =  userService.findByUsername("SauVT");
        oldUser.setUsername("SauVT2");
        userService.update(oldUser);
        User newUser =  userService.findByUsername("SauVT2");
        assertThat(newUser.getUsername(),is("SauVT2"));
    }

    @Test
    void deleteByUsername() {
        User user = userService.findByUsername("SauVT");
        assertThat(user,is(notNullValue(User.class)));
        userService.deleteByUsername("SauVT");
        boolean isDelete = userService.existByUsername("SauVT");
        assertThat(isDelete, is(false));
    }

    @Test
    void findCustomers() {
        Integer size=102;
        Pageable pageable = PageRequest.of(0, size);
        Page<User>customerPage=userService.findCustomers(pageable);
        assertThat(customerPage.getContent().isEmpty(),is(false));
        assertThat(customerPage.getSize(),is(size));
    }

    @Test
    void findMasters() {
        Integer size=10;
        Pageable pageable = PageRequest.of(0, size);
        Page<User>masterPage=userService.findMasters(pageable);
        assertThat(masterPage.getContent().isEmpty(),is(false));
        assertThat(masterPage.getSize(),is(size));
    }
}