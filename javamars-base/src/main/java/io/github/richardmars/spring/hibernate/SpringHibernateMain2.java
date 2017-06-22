package io.github.richardmars.spring.hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.richardmars.spring.hibernate.model.User;
import io.github.richardmars.spring.hibernate.service.UserService;

public class SpringHibernateMain2 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate2.xml");
		// 因为是components-scan并且@Service，所以会存在一个驼峰的userServiceImpl
		UserService userManager = (UserService) ctx.getBean("userServiceImpl");

		User user = new User();
		user.setUsername("johndoe");
		user.setName("John Doe");

		userManager.insertUser(user);

		System.out.println("User inserted!");

		user = userManager.getUser("johndoe");

		System.out.println("\nUser fetched by username!" + "\nId: " + user.getId() + "\nUsername: " + user.getUsername()
				+ "\nName: " + user.getName());

		user = userManager.getUserById(user.getId());

		System.out.println("\nUser fetched by ID!" + "\nId: " + user.getId() + "\nUsername: " + user.getUsername()
				+ "\nName: " + user.getName());

		List<User> users = userManager.getUsers();

		System.out.println("\nUser list fetched!" + "\nUser count: " + users.size());

	}
}
