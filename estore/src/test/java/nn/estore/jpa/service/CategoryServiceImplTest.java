package nn.estore.jpa.service;

import static org.hamcrest.MatcherAssert.assertThat;

import nn.estore.jpa.entity.Category;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
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
    private CategoryService categoryService;

    @Test
    void findAll() {
        List<Category> list = categoryService.findAll();
        assertThat(list, is(notNullValue()));
    }

    @Test
    void findById() {
        Category category = categoryService.findById(1079);
        assertThat(category,is(notNullValue(Category.class)));
        assertThat(category.getId(),is(1079));
    }

    @Test
    void create() {
        Category category = categoryService.create(new Category("test", "test"));
        List<Category> list = categoryService.findByName("test");
        assertThat(0, is(not(list.size())));
        assertThat(category, is(notNullValue()));
    }

    @Test
    void update() {
        Category category = categoryService.findById(1000);
        category.setName("hello world");
        categoryService.update(category);
        Category update = categoryService.findById(1000);
        assertThat(update.getName(),is("hello world"));
    }

    @Test
    void deleteById() {
        Category category = categoryService.findById(1001);
        categoryService.deleteById(1001);
        Assertions.assertNotNull(category);
    }
}