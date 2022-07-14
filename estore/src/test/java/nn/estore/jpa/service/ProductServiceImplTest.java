package nn.estore.jpa.service;

import nn.estore.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * nn.estore.jpa.service
 * Created by Admin
 * Date 7/4/2022 - 11:12 PM
 * Description: ...
 */

@SpringBootTest
@Transactional
class ProductServiceImplTest {
    @Autowired
    ProductService productService;

    @Test
    void findByCategory() {

    }

    @Test
    void findByName() {
    }

    @Test
    void findByDiscount() {
    }

    @Test
    void findById() {
        Product product =productService.findById(10001);
        assertThat(product, is(notNullValue()));
    }
}