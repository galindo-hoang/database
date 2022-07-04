package nn.estore.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nn.estore.jpa.dao.CategoryDAO;
import nn.estore.jpa.entity.Category;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDAO dao;

	@Override
	public List<Category> findAll() {
		return dao.findAll();
	}

	@Override
	public Category findById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public Category create(Category entity) {
		return dao.save(entity);
	}

	@Override
	public void update(Category entity) {
		dao.save(entity);
	}

	@Override
	public List<Category> findByName(String entity) {
		return dao.findByName(entity);
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

}
