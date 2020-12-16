package edu.poly.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.poly.spring.models.User;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean(name = "USER_BEAN")
	public User setUser() {
		User u = new User();
		u.setUsername("admin");
		u.setPassword("admin123");
		return u;
	}
}
