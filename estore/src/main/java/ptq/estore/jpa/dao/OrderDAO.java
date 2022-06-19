package ptq.estore.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ptq.estore.jpa.entity.Order;



public interface OrderDAO extends JpaRepository<Order, Long>{

}
