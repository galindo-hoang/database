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
import org.junit.Assert;
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
import org.springframework.transaction.annotation.Transactional;
import ptq.estore.EstoreApplication;
import ptq.estore.exception.InvalidQuantityException;
import ptq.estore.jpa.dao.ProductDAO;
import ptq.estore.jpa.entity.Product;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

	@Autowired
	ProductDAO productDAO;
	@Autowired
	ProductService productService;
	ProductDAO dao;


	@Test
	public void testCountByCategoryId(){
		Integer a = dao.findByCategoryId(1001);
		assertThat(11,is(a));
		System.out.println("Testcase Pass");
	}


		int id =1032;
			if (id == product.getId()) {

		System.out.println("Expect:" +Integer.toString(expect)+", Actual: "+Integer.toString(actual));
		assertThat(actual, Matchers.is(expect));
		System.out.println("Hoàn thành test case");
	}

}