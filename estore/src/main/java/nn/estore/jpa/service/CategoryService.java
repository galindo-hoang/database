package nn.estore.jpa.service;

import java.util.List;

import nn.estore.jpa.entity.Category;

public interface CategoryService{

	List<Category> findAll();

	Category findById(Integer id);

	Category create(Category entity);

	void update(Category entity);
	List<Category> findByName(String entity);
	void deleteById(Integer id);

}
