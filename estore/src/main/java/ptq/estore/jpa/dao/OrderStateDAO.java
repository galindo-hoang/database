package ptq.estore.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ptq.estore.jpa.entity.OrderState;



public interface OrderStateDAO extends JpaRepository<OrderState, Integer>{

}
