package ptq.estore.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.*;

import ptq.estore.jpa.entity.*;

public interface ProductService{

	Page<Product> findByCategory(Integer id, Pageable pageable);

	Page<Product> findByName(String name, Pageable pageable);

	Page<Product> findByDiscount(Pageable pageable);

	Page<Product> findByBest(Pageable pageable);

	Page<Product> findByFavorite(Pageable pageable);

	Page<Product> findByLatest(Pageable pageable);

	Product findById(Integer id);

	void update(Product product);
	
}
