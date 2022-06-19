package ptq.estore.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ptq.estore.jpa.entity.User;



public interface UserDAO extends JpaRepository<User, String>{
}
