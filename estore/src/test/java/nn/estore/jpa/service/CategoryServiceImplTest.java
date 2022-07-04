package nn.estore.jpa.service;

import static org.hamcrest.MatcherAssert.assertThat;

import nn.estore.jpa.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

@SpringBootTest
@Transactional
class CategoryServiceImplTest {
    @Autowired
    CategoryService categoryService;

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
        Category category = categoryService.create(new Category("test", "test"));
        List<Category> list = categoryService.findByName("test");
        assertThat(0, is(not(list.size())));
        assertThat(category, is(notNullValue()));
    }

    @Test
    void deleteById() {
    }
}