package ptq.estore.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ptq.estore.jpa.entity.Category;



public interface CategoryDAO extends JpaRepository<Category, Integer>{

}
