package estore;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.List;

import org.checkerframework.checker.units.qual.A;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.Matchers;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ptq.estore.EstoreApplication;
import ptq.estore.jpa.dao.ProductDAO;
import ptq.estore.jpa.entity.Product;
import ptq.estore.jpa.service.ProductService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import javax.swing.*;

/*@SpringBootTest*/
/*@ComponentScan*/
/*@RunWith(SpringRunner.class)
@DataJpaTest*/
@ComponentScan
@RunWith(value=SpringRunner.class)
@SpringBootTest(classes=EstoreApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EstoreApplicationTests extends DBTestCase{


	@Autowired
	ProductDAO productDAO;
	@Autowired
	ProductService productService;




	protected IDataSet getDataSet() throws Exception {
        return (IDataSet) productService.findAll();

    }
    protected DatabaseOperation getSetupOpration() throws Exception {
		return DatabaseOperation.REFRESH;
	}
    
    protected DatabaseOperation getTearDownOpration() throws Exception {
		return DatabaseOperation.DELETE_ALL;
	}


	@Test
	public void testFindCountProduct() throws  SQLException{
		int actual= (int) productService.findCount();
		int expect=23;
		System.out.println("Expect:" +Integer.toString(expect)+", Actual: "+Integer.toString(actual));
		assertThat(actual,is(expect));
		System.out.println("Hoàn thành test case");
	}

	/*@Test
	void testFindProductGroupBy() throws SQLException{
		List<Product> itemProduct=productDAO.findByBestIds();
		int id =1032;
		int actual = 0;
		int expect = 23;
		for (Product product : itemProduct) {
			actual++;
			if (id == product.getId()) {
				System.out.println(id);
				break;
			}
		}

		System.out.println("Expect:" +Integer.toString(expect)+", Actual: "+Integer.toString(actual));
		assertThat(actual, Matchers.is(expect));
		System.out.println("Hoàn thành test case");

	}*/


	@Test
	public void testFindProductById() throws SQLException {
		List<Product> itemProduct = productService.findAll();
		int id =1032;
		int actual = 0;
		int expect = 23;
		for (Product product : itemProduct) {
			actual++;
			if (id == product.getId()) {
				System.out.println(id);
				break;
			}
		}

		System.out.println("Expect:" +Integer.toString(expect)+", Actual: "+Integer.toString(actual));
		assertThat(actual, Matchers.is(expect));
		System.out.println("Hoàn thành test case");
	}

}