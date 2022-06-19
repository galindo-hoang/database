package ptq.estore.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptq.estore.jpa.dao.UserRoleDAO;



@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	UserRoleDAO dao;
}
