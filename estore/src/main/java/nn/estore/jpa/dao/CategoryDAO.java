package nn.estore.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nn.estore.jpa.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category, Integer>{
    List<Category> findByName(String name);
}
