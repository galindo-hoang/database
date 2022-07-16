package nn.estore.jpa.service;

import nn.estore.jpa.entity.Role;
import nn.estore.jpa.entity.User;
import nn.estore.jpa.entity.UserRole;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.NotNull;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.support.NullValue;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
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
        userService.create(new User("testFind", "2"));
        User user=userService.findByUsername("testFind");
        Role newRole=roleService.findAll().get(0);
        userRoleService.create(new UserRole(newRole,user));
        UserRole userRole= userRoleService.findByUserAndRole(user,newRole);
        userRoleService.delete(userRole);
        UserRole findUser= userRoleService.findByUserAndRole(user,newRole);
        assertThat(findUser, is(nullValue()));
    }


    @Test
    void delete() {
        userService.create(new User("testFind", "2"));
        User user=userService.findByUsername("testFind");
        Role newRole=roleService.findAll().get(0);
        userRoleService.create(new UserRole(newRole,user));
        UserRole userRole= userRoleService.findByUserAndRole(user,newRole);
        userRoleService.delete(userRole);
        UserRole findUser= userRoleService.findByUserAndRole(user,newRole);
        assertThat(findUser, is(nullValue()));
    }

    @Test
    void create() {
        userService.create(new User("testFind", "2"));
        User user=userService.findByUsername("testFind");
        Role newRole=roleService.findAll().get(0);
        userRoleService.create(new UserRole(newRole,user));
        UserRole userRole= userRoleService.findByUserAndRole(user,newRole);
        userRoleService.delete(userRole);
        UserRole findUser= userRoleService.findByUserAndRole(user,newRole);
        assertThat(findUser, is(nullValue()));
    }
}