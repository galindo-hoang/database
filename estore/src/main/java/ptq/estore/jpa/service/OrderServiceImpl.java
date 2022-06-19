package ptq.estore.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptq.estore.jpa.dao.OrderDAO;



@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderDAO dao;
}
