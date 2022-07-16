package nn.estore.jpa.service;

import nn.estore.jpa.entity.Role;
import nn.estore.jpa.entity.User;
import nn.estore.jpa.entity.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * nn.estore.jpa.service
 * Created by Admin
 * Date 7/16/2022 - 3:41 PM
 * Description: ...
 */
@SpringBootTest
@Transactional
class UserRoleServiceImplTest {
    @Autowired
    UserRoleService userRoleService;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;
    @Test
    void findAll() {
        List<UserRole> list = userRoleService.findAll();
        assertThat(list.isEmpty(), is(false));
    }

    @Test
    void findByUserAndRole() {
        /*String userName="user1";
        User user=userService.findByUsername(userName);
        System.out.println("user222"+user);*/
    }

    @Test
    void delete() {
        /*Role role=roleService.findById("SUPER");
        User user=userService.findByUsername("user1");
        userRoleService.delete(new UserRole(role,user));*/
    }

    @Test
    void create() {
       /* Role role=roleService.findById("SUPER");
        User user=userService.findByUsername("user3");
        UserRole userRole=new UserRole(role,user);
        userRoleService.create(userRole);*/
    }
}