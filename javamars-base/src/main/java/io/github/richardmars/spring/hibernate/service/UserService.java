package io.github.richardmars.spring.hibernate.service;

import java.util.List;

import io.github.richardmars.spring.hibernate.model.User;

public interface UserService {
	void insertUser(User user);

	User getUserById(int userId);

	User getUser(String username);

	List<User> getUsers();
}
