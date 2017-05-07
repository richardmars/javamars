package io.github.richardmars.spring.hibernate.dao;

import java.util.List;

import io.github.richardmars.spring.hibernate.model.User;

public interface UserDAO {
	void insertUser(User user);

	User getUserById(int userId);

	User getUser(String username);

	List<User> getUsers();
}
