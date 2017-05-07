package io.github.richardmars.spring.webmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.richardmars.spring.hibernate.model.User;
import io.github.richardmars.spring.hibernate.service.UserService;

@RestController
public class HelloWorldController {
	
	@Autowired
	private UserService userManager;
	
	@RequestMapping("/helloWorld")
	public String helloWorld() {
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
		return "Hello World";
	}
}
