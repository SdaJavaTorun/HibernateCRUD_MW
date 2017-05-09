package com.sdajava.hibernate.test;

import com.sdajava.hibernate.implement.UserDAOImpl;
import com.sdajava.hibernate.model.User;

public class HibernateTest {

	public static void main(String[] args) {

		UserDAOImpl userDAOImpl=new UserDAOImpl();
		User user =new User();
		user.setName("jan");
		user.setSurname("kowalski");
		userDAOImpl.insertUser(user);
		userDAOImpl.updateUser(1, "andrzej","test");
		userDAOImpl.getAllUsers();
		userDAOImpl.removeUser(1);
		user=null;
		userDAOImpl.findUser(1);
	}
}
