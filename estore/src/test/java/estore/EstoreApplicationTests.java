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
import ptq.estore.jpa.service.CategoryServiceImpl;

@RunWith(value= SpringRunner.class)
@SpringBootTest(classes = EstoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EstoreApplicationTests extends DBTestCase {
	@Autowired
	CategoryServiceImpl dao;

	@Test
	void contextLoads() {
	}

	@Test
	public void testById(){
		int userId = 1;
		Assertions.assertEquals(10, dao.count());
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

