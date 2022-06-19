package ptq.estore.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import ptq.estore.jpa.dao.ProductDAO;
import ptq.estore.jpa.entity.Product;



@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO dao;

	@Override
	public Page<Product> findByCategory(Integer id, Pageable pageable) {
		
		return dao.findByCategory(id, pageable);
	}

	@Override
	public Page<Product> findByName(String name, Pageable pageable) {
		
		return dao.findByCategory("%"+name+"%", pageable);
	}

	@Override
	public Page<Product> findByDiscount(Pageable pageable) {
		return dao.findByDiscount(pageable);
	}

	@Override
	public Page<Product> findByBest(Pageable pageable) {
		List<Integer> ids=dao.findByBestIds(pageable);
		return dao.findByIds(ids,pageable);
	}

	@Override
	public Page<Product> findByFavorite(Pageable pageable) {
		return dao.findByFavorite(pageable);
	}

	@Override
	public Page<Product> findByLatest(Pageable pageable) {
		return dao.findByLatest(pageable);
	}

	@Override
	public Product findById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public void update(Product product) {
		dao.save(product);
		return;
		
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

}
