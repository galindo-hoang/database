package estore;

import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ptq.estore.EstoreApplication;
import ptq.estore.jpa.dao.ProductDAO;
import ptq.estore.jpa.entity.Product;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(value= SpringRunner.class)
@SpringBootTest(classes = EstoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EstoreApplicationTests extends DBTestCase {
	@Autowired
	ProductDAO dao;

	@Test
	void contextLoads() {
	}


	@Test
	public void testCountByCategoryId(){
		Integer a = dao.findByCategoryId(1001);
		assertThat(11,is(a));
		System.out.println("Testcase Pass");
	}

	@Test
	public void testUpdate(){
		dao.updateNameById(1034,"hello world");
		assertThat("hello world",is(dao.findNameById(1034)));
		System.out.println("Testcase pass");
	}

	@Test
	public void testDelete(){
		assertThat("Outback Lager", is(dao.findNameById(1070)));
		System.out.println("Testcase pass");
	}

	@Test
	public void testCountAll(){
		Assertions.assertEquals(79, dao.count());
	}



	@Override
	protected IDataSet getDataSet() {
		return (IDataSet) dao.findAll();
	}

	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.REFRESH;
	}

	@Override
	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.DELETE_ALL;
	}
}

