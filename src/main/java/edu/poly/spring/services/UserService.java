package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import edu.poly.spring.models.User;
import edu.poly.spring.models.UserAuth;

public interface UserService {


	void deleteAll();

	void deleteAll(List<UserAuth> entities);

	void delete(UserAuth entity);

	void deleteById(Integer id);

	long count();

	List<UserAuth> findAllById(List<Integer> ids);

	List<UserAuth> findAll();

	boolean existsById(Integer id);

	Optional<UserAuth> findById(Integer id);

	List<UserAuth> saveAll(List<UserAuth> entities);

	UserAuth save(UserAuth entity);

//	boolean checkLogin(String username, String password);
	
	
}
