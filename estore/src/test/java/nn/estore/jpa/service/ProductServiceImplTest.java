package nn.estore.jpa.service;

`import nn.estore.jpa.entity.Category;
import nn.estore.jpa.entity.Product;
import nn.estore.jpa.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @Test
    void findByCategory() {
        //GIVEN
        Pageable pageable = PageRequest.of(0, 6);
        //THEN
        Page<Product> productPage = productService.findByCategory(1000, pageable);
        //WHEN
        Assertions.assertNotNull(productPage);
        Assertions.assertEquals(6, productPage.getContent().size());
    }

    @Test
    void findByName() {
        //GIVEN
        Pageable pageable = PageRequest.of(0, 6);
        //THEN
        Page<Product> productPage = productService.findByName("Change", pageable);
        //WHEN
        Assertions.assertNotNull(productPage);
        Assertions.assertEquals(1, productPage.getContent().size());
        Assertions.assertEquals("Change", productPage.getContent().get(0).getName());
    }

    @Test
    void findByDiscount() {
        //GIVEN
        Pageable pageable = PageRequest.of(0, 6);
        //THEN
        Page<Product> productPage = productService.findByDiscount(pageable);
        //WHEN
        Assertions.assertNotNull(productPage);
        Assertions.assertEquals(6, productPage.getContent().size());
    }

    @Test
    void findByBest() {
        //GIVEN
        Pageable pageable = PageRequest.of(0, 6);
        //THEN
        Page<Product> productPage = productService.findByBest(pageable);
        //WHEN
        Assertions.assertNotNull(productPage);
        Assertions.assertEquals(6, productPage.getContent().size());
    }

    @Test
    void findByFavorite() {
        //GIVEN
        Pageable pageable = PageRequest.of(0, 6);
        //THEN
        Page<Product> productPage = productService.findByFavorite(pageable);
        //WHEN
        Assertions.assertNotNull(productPage);
        Assertions.assertEquals(6, productPage.getContent().size());
    }

    @Test
    void findByLatest() {
        //GIVEN
        Pageable pageable = PageRequest.of(0, 6);
        //THEN
        Page<Product> productPage = productService.findByLatest(pageable);
        //WHEN
        Assertions.assertNotNull(productPage);
        Assertions.assertEquals(6, productPage.getContent().size());
    }

    @Test
    void findById() {
        //GIVEN
        //THEN
        Product product = productService.findById(1001);
        //WHEN
        Assertions.assertNotNull(product);
        Assertions.assertEquals("Aniseed Syrup", product.getName());
    }

    @Test
    void update() {
        //GIVEN
        Product product = productService.findById(1001);
        //THEN
        product.setName("Change");
        productService.update(product);
        //WHEN
        Assertions.assertEquals("Change", productService.findById(1001).getName());
    }

    @Test
    void findByUser() {
        //GIVEN
        Pageable pageable = PageRequest.of(0, 6);
        User user = userService.findByUsername("ALFKI");
        //THEN
        Page<Product> productPage = productService.findByUser(user, pageable);
        //WHEN
        Assertions.assertNotNull(productPage);
        Assertions.assertEquals(6, productPage.getContent().size());
    }

    @Test
    void findAll() {
        //GIVEN
        Pageable pageable = PageRequest.of(0, 6);
        //THEN
        Page<Product> productPage = productService.findAll(pageable);
        //WHEN
        Assertions.assertNotNull(productPage);
        Assertions.assertEquals(6, productPage.getContent().size());
    }

    @Test
    void deleteById() {
        //GIVEN
        Product product = productService.findById(1001);
        //THEN
        productService.deleteById(1001);
        //WHEN
        Assertions.assertNotNull(product);

    }

    @Test
    void create() {
        //GIVEN
        Category category = categoryService.findById(1000);
        Product product = productService.findById(1001);
        product.setUnitPrice(10.0);
        //WHEN
        productService.create(product);
        //THEN
        Assertions.assertNotNull(productService.findById(product.getId()));
    }

    @Test
    void testFindAll() {
        //WHEN
        List<Product> productList = productService.findAll();
        //THEN
        Assert.assertNotNull(productList);
        Assert.assertEquals(132, productList.size());

    }
}