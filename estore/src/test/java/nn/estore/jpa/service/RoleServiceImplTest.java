package nn.estore.jpa.service;

import nn.estore.jpa.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * nn.estore.jpa.service
 * Created by Admin
 * Date 7/16/2022 - 3:41 PM
 * Description: ...
 */
@SpringBootTest
@Transactional
class RoleServiceImplTest {
    @Autowired
    RoleService roleService;

    @Test
    void findAll() {
        List<Role> list = roleService.findAll();
        assertThat(list.isEmpty(), is(false));
    }

    @Test
    void findById() {
        String id="ADMIN";
        Role role=roleService.findById(id);
        assertThat(role.getId(), is(id));
    }
}