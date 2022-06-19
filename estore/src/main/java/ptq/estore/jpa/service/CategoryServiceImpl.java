package ptq.estore.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptq.estore.jpa.dao.CategoryDAO;
import ptq.estore.jpa.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDAO dao;

	@Override
	public List<Category> findAll() {
		return dao.findAll();
	}

	@Override
	public long count() {

		return dao.count();
	}
}
