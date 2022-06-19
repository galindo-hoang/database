package ptq.estore.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ptq.estore.jpa.entity.OrderDetail;



public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{

}
