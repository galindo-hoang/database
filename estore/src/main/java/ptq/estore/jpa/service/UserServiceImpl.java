package ptq.estore.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptq.estore.jpa.dao.UserDAO;



@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO dao;
}
